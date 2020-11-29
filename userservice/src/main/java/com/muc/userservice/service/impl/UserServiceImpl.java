package com.muc.userservice.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.muc.userservice.config.ConfigInfo;
import com.muc.userservice.entity.User;
import com.muc.userservice.mapper.UserMapper;
import com.muc.userservice.model.*;
import com.muc.userservice.service.UserService;
import com.muc.userservice.util.Encryption;
import com.muc.userservice.util.JwtUtil;
import com.muc.userservice.util.SecureRandomUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@Slf4j
public class UserServiceImpl  implements UserService {
    @Autowired
    private  UserMapper userMapper;
    @Value("${userservice.system.name}")
    private String systemName;
    @Autowired
    private JwtUtil jwtUtil;
    @Override

    public int register(ReqRegisterVo request) {
        String mobile="";
        if(StringUtils.isNotBlank(request.getMobile())) {
            mobile="86"
                    .concat(request.getMobile().substring(0,3))
                    .concat("****")
                    .concat(request.getMobile().substring(7,11));
        }

        User user=User.builder()
                .cid(getCidSeq(systemName))
                .firstname(request.getFirstname())
                .lastname(request.getLastName())
                .mobile(mobile)
                .nickName(request.getNickName())
                .password(Encryption.encrypt(request.getPassword(),ConfigInfo.dataSecret,ConfigInfo.dataSecretIv,"UTF-8"))
                .aesMobile(Encryption.encrypt(request.getMobile(),ConfigInfo.dataSecret,ConfigInfo.dataSecretIv,"UTF-8"))
                .build();
        return userMapper.insert(user);
    }

    @Override
    @Transactional
    public Result<RespLoginVo> login(ReqLoginVo reqLoginVo) {
        String aesMoblie=Encryption.encrypt(reqLoginVo.getMobile(),ConfigInfo.dataSecret,ConfigInfo.dataSecretIv,"UTF-8");
        String password=Encryption.encrypt(reqLoginVo.getPassword(),ConfigInfo.dataSecret,ConfigInfo.dataSecretIv,"UTF-8");
        QueryWrapper<User> queryWrapper=new QueryWrapper<User>();
        log.info("username {} passowrd {}",aesMoblie,password);
        queryWrapper.eq("aes_mobile",aesMoblie);
        queryWrapper.eq("password",password);
        User user=userMapper.selectOne(queryWrapper);
        if(user!=null){
          return ResultGenerator.genSuccessResult( RespLoginVo.builder()
                  .cid(user.getCid())
                  .mobile(user.getAesMobile())
                  .apiToken(jwtUtil.createJWT(7200000,user))
                  .expireTime(System.currentTimeMillis()+7200000)
                  .avatar(user.getAvatar())
                  .nickName(user.getNickName())
                  .build());
        }

        return ResultGenerator.genFailResult("登录失败");


    }
    private String getCidSeq(String operateorId) {
        SecureRandomUtil random = new SecureRandomUtil();
        StringBuilder sb = new StringBuilder();
        sb.append(operateorId);
        sb.append(DateFormatUtils.format(new Date(), "yyyyMMddHHmmss"));
        sb.append(random.nextInt(10));
        sb.append(random.nextInt(10));
        sb.append(random.nextInt(10));
        sb.append(random.nextInt(10));
        return sb.toString();
    }
}
