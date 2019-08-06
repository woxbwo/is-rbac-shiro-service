package com.is.shiro.service.controller;

import com.is.shiro.service.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: PublicController
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.08.07 2:52
 */
@RestController
@RequestMapping("pub")
public class PublicController {
    @Autowired
    private UserServiceImpl userService;
    @RequestMapping("find_user_info")
    public Object findUserInfo(@RequestParam("username")String username){
        return userService.findAllUserInfoByUsername(username);
    }
}
