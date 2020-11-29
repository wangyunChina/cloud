package com.muc.communityservice;

import com.muc.communityservice.consts.FileContentTypeEnum;
import org.junit.Test;

public class MainTest {
    @Test
    public void mainTest(){
        String sufix="8T1YWDEV202011222326548917MP4".substring(26);

       System.out.print( FileContentTypeEnum.valueOf(sufix).getType());
    }
}
