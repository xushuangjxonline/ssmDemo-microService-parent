package com.jxonline.sword.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密工具类
 * @author xs
 * @date 2022/9/14
 **/
public class MD5Util {

    public static String getMD5String(String source){

        //判断要加密的字符串是否为空
        if(source == null || "".equals(source)){
            throw new RuntimeException("要加密的字符串不能为空");
        }


        //获取MessageDigest对象
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance("MD5");
        }catch (NoSuchAlgorithmException e){
            e.printStackTrace();
        }


        //或许要加密的字符串对应的字节数组
        byte[] input = source.getBytes();


        //执行加密
        assert messageDigest != null;
        byte[] output = messageDigest.digest(input);


        //创建BigInteger对象
        int signum = 1;
        BigInteger bigInteger = new BigInteger(signum , output);

        //按照16进制将bigInteger的值转换为字符串


        return bigInteger.toString(16).toUpperCase();
    }

}
