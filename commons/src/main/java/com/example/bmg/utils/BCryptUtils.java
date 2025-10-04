package com.example.bmg.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptUtils {

    /**
     * 加密
     *
     * @param password
     * @return
     */
    public static String encodePassWord(String password) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encode = bCryptPasswordEncoder.encode(password);
        return encode;
    }

    /**
     * 验证是否正确
     * @param password
     * @param encodedPassword
     * @return
     */
    public static boolean matches(String password, String encodedPassword) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder.matches(password, encodedPassword);
    }

    public static void main(String[] args) throws Exception{
        String s="123456";
        String p = Md5Utils.encodeByMd5(s);

        for (int i = 0; i < 10; i++) {
                    String result = BCryptUtils.encodePassWord(p);
                    System.out.println(result);
        }
//        String s="$2a$10$av7z7wogPCduJ1KBHhBmGO3f9fe3uLL7gE24co1/hE/xQjIynnj.6";
//        boolean b = BCryptUtils.matches("bruce23", s);
//        System.out.println(b);
    }

}
