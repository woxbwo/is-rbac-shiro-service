package com.is.shiro.service.dao;

import com.is.shiro.service.domain.Permission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @ClassName: PermissionMapper
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.08.07 2:06
 */
public interface PermissionMapper {
    @Select("select p.id as id, p.name as name, p.url as url from  role_permission rp " +
            "left join permission p on rp.permission_id=p.id " +
            "where  rp.role_id= #{roleId} ")
    List<Permission> findPermissionListByRoleId(@Param("roleId") int roleId);
}
