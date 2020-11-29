package com.muc.service;

import com.muc.bean.HandsUser;
import com.muc.mapper.HandsUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class HandsUserServiceImp implements HandsUserService {
    @Resource
    HandsUserMapper handsUserMapper;
    @Override
    public int reg(HandsUser handsUser) {
        try{
            this.handsUserMapper.insert(handsUser);
            return 1;
        }
        catch (Exception e)
        {
            return 0;
        }

    }

    @Override
    public HandsUser login(HandsUser handsUser) {
        try {
            HandsUser temp = this.handsUserMapper.selectToLogin(handsUser.getUsername(), handsUser.getHandsPassword());
            if (temp!=null) {
                return temp;
            } else return null;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public int changePassword(HandsUser handsUser) {
        try {
            return this.handsUserMapper.updateByPrimaryKey(handsUser);
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return 0;
        }

    }

}
