package com.is.shiro.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @ClassName: RbacShiroApplication
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.08.07 1:42
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.is.shiro.service.dao"})
public class RbacShiroApplication {
    public static void main(String[] args) {
        SpringApplication.run(RbacShiroApplication.class,args);
    }
}
