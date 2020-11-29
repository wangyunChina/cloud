package com.muc.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;
@Service
public class EpieServiceImp  implements EpieService{
    @Override
    public Map login_by_weixin(String code, String encryptedData, String iv, HttpServletRequest request) {
        return null;
    }
}
