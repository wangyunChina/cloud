package com.muc.service;

import com.muc.bean.ChartMessage;
import com.muc.mapper.ChartMessageMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;

@Service
public class ChartMessageServiceImp implements ChartMessageService {
    @Resource
    ChartMessageMapper chartMessageMapper;
    @Override
    public int sendMessage(ChartMessage message) {
       return this.chartMessageMapper.insert(message);

    }

    @Override
    public HashMap<String, Object> readMessage(String from, String to) {
        HashMap<String, Object> map=new HashMap();
        try {
            ArrayList<ChartMessage> list=this.chartMessageMapper.selectByProporty(from, to);
            map.put("result","success");
            map.put("data",list);
        }
        catch (Exception e)
        {
            map.put("result","fail");
            map.put("errorMessage","没有该联系人！");
        }
        return map;
    }

    @Override
    public HashMap<String, Object> readAllNotReadMessage(String to) {
        HashMap <String,Object> map=new HashMap<>();
        ArrayList<ArrayList> messageArray=new ArrayList<>();
        try {

            ArrayList<ChartMessage> list1 = this.chartMessageMapper.selectNotReadMan(to);
            for (ChartMessage i : list1
            ) {
               String from=i.getMessageFrom();
               ArrayList temp=this.chartMessageMapper.selectByProporty(from,to);
               messageArray.add(temp);

            }
            map.put("result","success");
            map.put("data",messageArray);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return map;
    }
}
