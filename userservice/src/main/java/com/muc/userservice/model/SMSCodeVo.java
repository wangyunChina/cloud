package com.muc.userservice.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class SMSCodeVo {
    private String code;
    private LocalDateTime expireTime;
}
