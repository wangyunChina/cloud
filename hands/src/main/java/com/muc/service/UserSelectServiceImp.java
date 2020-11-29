package com.muc.service;

import com.muc.bean.UserSelect;
import com.muc.bean.UserSelectKey;
import com.muc.mapper.UserSelectMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
@Service("UserSelectService")
public class UserSelectServiceImp implements UserSelectService {
    @Resource
    UserSelectMapper userSelectMapper;


    @Override
    public ArrayList<UserSelect> selectByWxid(String wxid) {
        return userSelectMapper.selectByWxid(wxid);
    }

    @Override
    public int deleteByKey(UserSelectKey key) {
        return userSelectMapper.deleteByPrimaryKey(key);
    }

    @Override
    public int insert(UserSelect select) {
        return userSelectMapper.insert(select);
    }

    @Override
    public int update(UserSelect select) {
        return userSelectMapper.updateByPrimaryKey(select);
    }
}
