package com.muc.service;

import com.muc.bean.UserSelect;
import com.muc.bean.UserSelectKey;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

public interface UserSelectService {

    public ArrayList<UserSelect> selectByWxid(String wxid);

    public int deleteByKey(UserSelectKey key);

    public int insert(UserSelect select);

    public int update(UserSelect select);
}
