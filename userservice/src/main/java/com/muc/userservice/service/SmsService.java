package com.muc.userservice.service;

import com.aliyuncs.exceptions.ClientException;
import com.muc.userservice.model.ReqSMSSendVo;

public interface SmsService {
    void sendSms(ReqSMSSendVo smsSendVo) throws ClientException;
}
