package com.muc.userservice.service;

import com.aliyuncs.exceptions.ClientException;
import com.muc.userservice.model.ReqSMSCheckVo;
import com.muc.userservice.model.ReqSMSSendVo;
import com.muc.userservice.model.Result;

public interface SmsService {
    Result sendSms(ReqSMSSendVo smsSendVo) throws ClientException;
    Result check(ReqSMSCheckVo smsCheckVo);
}
