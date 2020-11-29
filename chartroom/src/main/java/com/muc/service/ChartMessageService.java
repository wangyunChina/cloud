package com.muc.service;

import com.muc.bean.ChartMessage;

import java.util.HashMap;

public interface ChartMessageService {
    public int sendMessage(ChartMessage message);
    public HashMap<String,Object> readMessage(String from, String to);
    public HashMap<String,Object> readAllNotReadMessage(String to);
}
