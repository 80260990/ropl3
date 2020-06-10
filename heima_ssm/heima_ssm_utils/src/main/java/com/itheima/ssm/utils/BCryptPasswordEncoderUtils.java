package com.itheima.ssm.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Classname BCryptPasswordEncoderUtils
 * @Description TODO
 * @Date 2020/5/23 12:01
 * @Created by Leslie
 */
public class BCryptPasswordEncoderUtils {
    private static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();

    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }


    public static void main(String[] args) {
        String password = "123456";
        System.out.println(encodePassword(password));
        //每次加密的结果是不一样的
    }
}
