package com.muc.userservice.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.A;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserPower {
    private String cid;
    private int read;
    private int share;
    private int like;
    private int comments;
    private int upload;
    private int deleteOthersComments;
    private int news;



}
