package com.muc.zuul.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Token {
    private String apiToken;
    private long expire;

    public boolean isTimeout(){
        if(expire-System.currentTimeMillis()>0)
        {
            return false;
        }
        return true;
    }
}
