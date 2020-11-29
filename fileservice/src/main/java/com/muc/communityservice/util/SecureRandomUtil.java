package com.muc.communityservice.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
  * 产生可靠随机数工具类
  * @author hyw
  * @date 2020-10-27
 */
public class SecureRandomUtil {

    private SecureRandom secureRandom ;

    public SecureRandomUtil(){
        try {
            secureRandom = SecureRandom.getInstance("NativePRNGNonBlocking");
        } catch (NoSuchAlgorithmException e) {
            secureRandom = new SecureRandom();
        }
    }

    public int nextInt(int i){
        return secureRandom.nextInt(i);
    }

    public double nextDouble(){
        return secureRandom.nextDouble();
    }

    public static void main(String[] args) {
        System.out.println(new SecureRandomUtil().nextInt(10));
        System.out.println( new SecureRandomUtil().nextDouble() );
//        System.out.println(Math.random());
    }

}
