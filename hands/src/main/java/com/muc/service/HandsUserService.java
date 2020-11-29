package com.muc.service;

import com.muc.bean.HandsUser;
import org.springframework.stereotype.Service;


public interface HandsUserService {
    public int reg(HandsUser handsUser);
    public HandsUser login(HandsUser handsUser);
    public int changePassword(HandsUser handsUser);

}
