package com.muc.service;

import com.muc.bean.Book;
import net.sf.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public interface BookService {
    public ArrayList<Book> selectAll();
    public Book selectById(Integer id);
    public int deleteById(Integer id);
    public int deleteByRecord(Book record);
}
