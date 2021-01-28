package com.muc.zuul.filter;

import com.google.gson.Gson;
import com.muc.zuul.model.ResultGenerator;
import com.muc.zuul.pool.TokenPool;
import com.muc.zuul.utils.JwtUtil;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;

@Component
public class ManagerFilter extends ZuulFilter {
    @Autowired
    private JwtUtil jwtUtil;

    /**
     * 在请求前pre或者后post执行
     * @return
     */
    @Override
    public String filterType() {
        return "pre";
    }

    /**
     * 多个过滤器的执行顺序，数字越小，表示越先执行
     * @return
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     * 当前过滤器是否开启true表示开启
     * @return
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器内执行的操作 return 任何ojbect的值都表示继续执行
     * setsendzullRespponse(false)表示不再继续执行
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        System.out.println("经过后台过滤器了！");
        RequestContext requestContext = RequestContext.getCurrentContext();
        //request域
        HttpServletRequest request = requestContext.getRequest();

        if(request.getMethod().equals("OPTIONS")){  //预请求 放行
            return null;
        }

        if(request.getRequestURI().indexOf("login")>0){ //登录请求放行
            return null;
        }
        if(request.getRequestURI().indexOf("register")>0){ //登录请求放行
            return null;
        }
        if(request.getRequestURI().indexOf("open")>0){ //登录请求放行
            return null;
        }
        if(request.getRequestURI().indexOf("doc")>0){ //登录请求放行
            return null;
        }
        if(request.getRequestURI().indexOf("webjars")>0){ //登录请求放行
            return null;
        }
        if(request.getRequestURI().indexOf("swagger-resources")>0){ //
            return null;
        }
        if(request.getRequestURI().indexOf("html")>0){ //
            return null;
        }
        if(request.getRequestURI().indexOf("js")>0){ //
            return null;
        }
        if(request.getRequestURI().indexOf("css")>0){ //
            return null;
        }
        if(request.getRequestURI().indexOf("png")>0){ //
            return null;
        }
        if(request.getRequestURI().indexOf("font")>0){ //
            return null;
        }
        if(request.getRequestURI().indexOf("english")>0){ //
            return null;
        }

        //得到头信息
        String header = request.getHeader("Authorization");
        String cid = request.getHeader("cid");
        String message="cid不能为空";
        if(!StringUtils.isEmpty(cid)&&header!=null && !"".equals(header)){
            if(header.startsWith("Bearer")){
                String token = header.substring(7);
                try {
                    Claims claims = jwtUtil.parseJWT(token,null);
                    String roles = (String) claims.get("roles");
                    if("admin".equals(roles)){
                        //把头信息转发下去，并且放行
                        requestContext.addZuulRequestHeader("Authorization", header);
                        return null;
                    }
                    else if(jwtUtil.isVerify(token,cid)){
                        return null;
                    }else{
                        message="apiToken invalid";
                    }

                }catch (ExpiredJwtException e1){
                    e1.printStackTrace();
                    message="apiToken time out";
                    requestContext.setSendZuulResponse(false);//终止运行
                }
                catch (Exception e){
                    e.printStackTrace();
                    message="apiToken invalid";
                    requestContext.setSendZuulResponse(false);//终止运行
                }
            }
        }
        requestContext.setSendZuulResponse(false);//终止运行
        requestContext.setResponseStatusCode(401);
        requestContext.setResponseBody(new Gson().toJson(ResultGenerator.genErrorResult(401,message)));
        requestContext.getResponse().setContentType("json/application;charset=utf-8");
        return null;
    }
}