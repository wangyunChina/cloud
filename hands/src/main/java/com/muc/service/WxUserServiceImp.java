package com.muc.service;

import com.muc.bean.WxUser;
import com.muc.mapper.WxUserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service("WxUserService")
public class WxUserServiceImp implements WxUserService {
    @Resource
    WxUserMapper wxUserMapper;
    @Override
    public int insert(WxUser record) {
        return wxUserMapper.insert(record);
    }
    public int insert(String wxid,String wxname) {
        WxUser wxUser=new WxUser();
        wxUser.setUsername(wxname);
        wxUser.setWxid(wxid);
        return wxUserMapper.insert(wxUser);
    }
}
