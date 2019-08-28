package com.is.shiro.service.domain;

import java.io.Serializable;

/**
 * @ClassName: RolePermission
 * @Description:
 * 角色权限对应类
 * @Author: Coding_wxb
 * @Date 2019.08.07 1:57
 */
public class RolePermission implements Serializable {
    private int id;

    private int roleId;

    private int permissionId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public int getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(int permissionId) {
        this.permissionId = permissionId;
    }
}
