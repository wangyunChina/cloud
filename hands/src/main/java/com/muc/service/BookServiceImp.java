package com.muc.service;

import com.muc.bean.Book;
import com.muc.mapper.BookMapper;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
@Service("BookService")
public class BookServiceImp implements BookService {
    @Resource BookMapper bookMapper;
    @Override
    public ArrayList<Book> selectAll() {

        ArrayList<Book> arrayList=bookMapper.selectAll();
        ArrayList<JSONObject> arrayList1=new ArrayList<>();
        /*for (Book i:arrayList
             ) {
            JSONObject j=JSONObject.fromObject(i);
            arrayList1.add(j);
        }*/
        return arrayList;
    }

    @Override
    public Book selectById(Integer id) {
        return bookMapper.selectByPrimaryKey(id);
    }

    @Override
    public int deleteById(Integer id) {
        return bookMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int deleteByRecord(Book record) {
        return bookMapper.updateByPrimaryKey(record);
    }
}
