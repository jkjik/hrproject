package com.jikjk.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by lenovo on 2018/10/12.
 */
public class Md5 {
    public static String md5(String src){
        StringBuffer buffer = new StringBuffer();
        char[] chars = {'0','1','2','3','4','5','6','7','8','9',
                'a','b','c','d','e','f'};
        byte[] bytes = src.getBytes();
        //MD5¼ÓÃÜËã·¨
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] target = md.digest(bytes);
            for (byte b : target) {
                buffer.append(chars[(b>>4)&0x0F]);
                buffer.append(chars[b&0x0F]);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return buffer.toString();
    }

}
