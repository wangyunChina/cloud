package com.muc.userservice.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author 王云
 * @Description 用户实体类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User extends Model<User> {
    private String cid;
    private String firstname;
    private String lastname;
    private String mobile;
    private String aesMobile;
    private String password;
    private String nickName;
    private String avatar;
}
