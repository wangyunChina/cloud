package com.muc.action;

import com.muc.bean.ChartMessage;
import com.muc.bean.HandsUser;
import com.muc.mapper.HandsUserMapper;
import com.muc.service.ChartMessageService;
import com.muc.service.HandsUserService;
import com.muc.service.HandsUserServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.sql.Date;
import java.util.concurrent.CopyOnWriteArraySet;

//@ServerEndpoint("/websocket/{user}")
@ServerEndpoint("/websocket/{username}/{password}/{aim}")
@Component
public class WebSocketServer implements ApplicationContextAware {
    private static final Logger log = LoggerFactory.getLogger(WebSocketServer.class);
    //静态变量，用来记录当前在线连接数。应该把它设计成线程安全的。
    private static int onlineCount = 0;
    //concurrent包的线程安全Set，用来存放每个客户端对应的MyWebSocket对象。
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet = new CopyOnWriteArraySet<WebSocketServer>();
    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;
    private  String aim;
    private HandsUser user;
    private static ApplicationContext applicationContext = null;


    public String getAim() {
        return aim;
    }

    public HandsUser getUser() {
        return user;
    }

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(@PathParam("username") String username,@PathParam("password") String password,@PathParam("aim") String aim, Session session) {
        HandsUser handsUser=new HandsUser();
        handsUser.setUsername(username);
        handsUser.setHandsPassword(password);
        System.out.println(handsUser.getUsername()+handsUser.getHandsPassword());
        HandsUserService handsUserService=WebSocketServer.getBean(HandsUserService.class);
        this.user=handsUserService.login(handsUser);
        if(this.user==null)
        {
            log.info("连接失败，用户信息不正确！");
        }
        this.aim=aim;
        this.session = session;
        //加入set中
        webSocketSet.add(this);
        //在线数加1
        addOnlineCount();
        log.info("有新连接加入！当前在线人数为" + getOnlineCount());

    }
    //	//连接打开时执行
    //	@OnOpen
    //	public void onOpen(@PathParam("user") String user, Session session) {
    //		currentUser = user;
    //		System.out.println("Connected ... " + session.getId());
    //	}

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        webSocketSet.remove(this);  //从set中删除
        subOnlineCount();           //在线数减1
        log.info("有一连接关闭！当前在线人数为" + getOnlineCount());
    }

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) {
        ChartMessageService chartMessageService=WebSocketServer.getBean(ChartMessageService.class);
        log.info("来自客户端的消息:" + message);
        boolean isonline=false;
        //群发消息
        for (WebSocketServer item : webSocketSet) {
            try {
                log.info(item.aim+"&"+this.getUser());
                if(item.getUser().getUsername().equals(this.aim)&&item.aim.equals(this.getUser().getUsername())) {
                    item.sendMessage(item.getUser().getUsername()+":"+message);
                    isonline=true;
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            try{
                if(isonline==false)
                {
                    ChartMessage chartMessage=new ChartMessage();
                    chartMessage.setMessageFrom(this.user.getUsername());
                    chartMessage.setMessageTo(this.aim);
                    chartMessage.setMessage(message);
                    Date date=new Date(System.currentTimeMillis());
                    chartMessage.setSendTime(date);
                    chartMessage.setIsread(Byte.parseByte("0"));
                  chartMessageService.sendMessage(chartMessage);
                }
            }
            catch (Exception e){
                System.out.println(e.getMessage());
                System.out.println("对方不在线已经存入数据库！");
            }
        }
    }

    /**
     * @param session
     * @param error
     */
    @OnError
    public void onError(Session session, Throwable error) {
        log.error("发生错误");
        error.printStackTrace();
    }

    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    /**
     * 群发自定义消息
     */
    public static void sendInfo(String message) {
        log.info(message);
        for (WebSocketServer item : webSocketSet) {
            try {
                item.sendMessage(message);
            } catch (IOException ignored) {
            }
        }
    }

    private static synchronized int getOnlineCount() {
        return onlineCount;
    }

    private static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    private static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        if(WebSocketServer.applicationContext==null){
            WebSocketServer.applicationContext=applicationContext;
        }
    }
    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    //通过name获取 Bean.
    public static Object getBean(String name){
        return getApplicationContext().getBean(name);

    }

    //通过class获取Bean.
    public static <T> T getBean(Class<T> clazz){
        return getApplicationContext().getBean(clazz);
    }

    //通过name,以及Clazz返回指定的Bean
    public static <T> T getBean(String name,Class<T> clazz){
        return getApplicationContext().getBean(name, clazz);
    }

}
