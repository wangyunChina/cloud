package com.muc.service;

import com.muc.bean.HandsUser;


public interface HandsUserService {
    public int reg(HandsUser handsUser);
    public HandsUser login(HandsUser handsUser);
    public int changePassword(HandsUser handsUser);

}
