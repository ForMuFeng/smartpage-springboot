package com.yqy.smartpage.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/**
 * @program: smartpage-springboot
 * @description:普通的工具函数
 * @author: Mr.Yqy
 * @create: 2019-05-08 22:32
 **/
public class Utils {



    private static MessageDigest md5;

    static {
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 获取md5
     * @param string
     * @return
     */
    public static String getMd5(String string) {
        try {
            byte[] bs = md5.digest(string.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(40);
            for (byte x : bs) {
                if ((x & 0xff) >> 4 == 0) {
                    sb.append("0").append(Integer.toHexString(x & 0xff));
                } else {
                    sb.append(Integer.toHexString(x & 0xff));
                }
            }
            return sb.toString();
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

}
