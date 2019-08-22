package com.is.service;

import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * @ClassName: MD5Test
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.08.23 3:33
 */
public class MD5Test {
    public static void main(String[] args) {
        System.out.println(new SimpleHash("md5","123",null,2));
    }
}
