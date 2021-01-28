package com.muc.userservice.model;

import com.alibaba.fastjson.JSON;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Builder
@Data
public class SMSTemplate {
    private String templateId;
    private String templateParam;
}
