package com.is.shiro.service.domain;

import java.io.Serializable;

/**
 * @ClassName: UserRole
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.08.07 1:56
 */
public class UserRole implements Serializable {
    private int id;

    private int userId;

    private int roleId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
