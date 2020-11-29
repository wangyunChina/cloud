package com.muc.action;

import com.muc.bean.Book;
import com.muc.bean.User;
import com.muc.service.BookService;
import com.muc.service.UserSelectService;
import com.muc.service.WxUserService;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
@CrossOrigin
@RestController
@RequestMapping("/EnglishStudy")
public class CustomerAction {
    @Resource
    BookService bookService;
    @Resource
    WxUserService wxUserService;
    @Resource
    UserSelectService userSelectService;

    @RequestMapping("/books")
    public HashMap<String,Object>  allBook()
    {
        HashMap map=new HashMap<String,Object>();
        ArrayList<Book> books=bookService.selectAll();
        //JSONArray jsonObject=JSONArray.fromObject(books);
        ArrayList<User> user=new ArrayList<User>();
        user.add(new User("17040065","123321","王云"));
        map.put("code",true);
        map.put("user",books.get(1));
        return map;
    }
}
