package com.muc.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Card {
    private String cardId;
    private String createTime;
    private String bindTime;
    private String cardType;
    private int status;
    private String expiresTime;

}
