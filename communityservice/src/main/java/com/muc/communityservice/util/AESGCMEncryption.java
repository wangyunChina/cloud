package com.muc.communityservice.util;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

@Slf4j
public class AESGCMEncryption
{
    private static String gcm256algorithm = "AES/GCM/PKCS5Padding";
    private static String gcmSecretKey="cH3kK6LV095FnNUmlmUTcdZ/QwjHTS3iJ2bFMsbRXbc=";

    public static String decryptContent(String content, String keyStr) {
        try {
            if (StringUtils.isEmpty(content) || StringUtils.isEmpty(keyStr)) {
                throw new Exception("AESGCM256解密异常,检查文本或密钥");
            }


            //Cipher cipher = Cipher.getInstance(gcm256algorithm);
            Cipher cipher = Cipher.getInstance(gcm256algorithm);
            SecretKey key = new SecretKeySpec(Base64.decodeBase64(keyStr), "AES");

            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] message = Base64.decodeBase64(content);
            if (message.length < 12 + 16) throw new IllegalArgumentException();
            GCMParameterSpec params = new GCMParameterSpec(128, message, 0, 12);
            cipher.init(Cipher.DECRYPT_MODE, key, params);
            byte[] decryptData = cipher.doFinal(message, 12, message.length - 12);
            String decript = new String(decryptData);
            log.info("content:{}, after decrypt:{}",content,decript);
            return decript;
        } catch (Exception e) {
            log.error("AESGCM256解密文本处理失败,error:{}", e);
        }
        return null;
    }

    public static String encryptContent(String content, String keyStr) {
        try {
            if (StringUtils.isEmpty(content) || StringUtils.isEmpty(keyStr)) {
                throw new Exception("AESGCM256加密异常,检查文本或密钥");
            }

            SecretKey secretKey = new SecretKeySpec(Base64.decodeBase64(keyStr), "AES");

            //Cipher cipher = Cipher.getInstance(gcm256algorithm);
            Cipher cipher = Cipher.getInstance(gcm256algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] iv = cipher.getIV();
            assert iv.length == 12;
            byte[] encryptData = cipher.doFinal(content.getBytes());
            assert encryptData.length == content.getBytes().length + 16;
            byte[] message = new byte[12 + content.getBytes().length + 16];
            System.arraycopy(iv, 0, message, 0, 12);
            System.arraycopy(encryptData, 0, message, 12, encryptData.length);
            return Base64.encodeBase64String(message);
        } catch (Exception e) {
            log.error("AESGCM256加密文本处理失败,error:{}", e);
        }
        return null;

    }

    public static void main(String[] args) {
        log.info("密钥：" + gcmSecretKey);

        String txt = "测试内容:AESGCM256加密文本测试";
        String content = encryptContent(txt, gcmSecretKey);
        log.info("加密后：" + content);
        String realTxt = decryptContent(content, gcmSecretKey);
        log.info("解密后:" + realTxt);
    }
}
