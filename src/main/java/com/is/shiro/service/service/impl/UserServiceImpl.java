package com.is.shiro.service.service.impl;

import com.is.shiro.service.dao.RoleMapper;
import com.is.shiro.service.dao.UserMapper;
import com.is.shiro.service.domain.Role;
import com.is.shiro.service.domain.User;
import com.is.shiro.service.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: UserServiceImpl
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.08.07 2:47
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public User findAllUserInfoByUsername(String username) {
        /**
         *再也逻辑处理加缓存，或者在realm中加缓存
         **/
        User user = userMapper.findByUsername(username);
        //用户的角色集合
        List<Role> roleList = roleMapper.findRoleListByUserId(user.getId());
        user.setRoleList(roleList);
        return user;
    }


    @Override
    public User findSimpleUserInfoById(int userId) {
        return userMapper.findById(userId);
    }


    @Override
    public User findSimpleUserInfoByUsername(String username) {
        return userMapper.findByUsername(username);
    }
}
