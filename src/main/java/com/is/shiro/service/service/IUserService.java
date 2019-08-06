package com.is.shiro.service.service;

import com.is.shiro.service.domain.User;

/**
 * @ClassName: IUserService
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.08.07 2:46
 */
public interface IUserService {
    /**
     * 获取全部用户信息，包括角色，权限
     * @param username
     * @return
     */
    User findAllUserInfoByUsername(String username);


    /**
     * 获取用户基本信息
     * @param userId
     * @return
     */
    User findSimpleUserInfoById(int userId);


    /**
     * 根据用户名查找用户信息
     * @param username
     * @return
     */
    User findSimpleUserInfoByUsername(String username);
}
