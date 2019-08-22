package com.is.shiro.service.config;

import com.is.shiro.service.domain.Role;
import com.is.shiro.service.domain.User;
import com.is.shiro.service.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: CustomRealm
 * 自定义Realm
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.08.13 11:30
 */
public class CustomRealm extends AuthorizingRealm {
    @Autowired
    private IUserService userService;

    /**
     * 进行权限校验时会调用
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("授权 doGetAuthorizationInfo");
        String userName = (String) principalCollection.getPrimaryPrincipal();
        User user = userService.findAllUserInfoByUsername(userName);
        List<String> roleList = new ArrayList<>();
        List<String> permissionList = new ArrayList<>();
        user.getRoleList().forEach(role -> {
            roleList.add(role.getName());
            role.getPermissionList().forEach(permission -> {
                if(permission!=null){
                    permissionList.add(permission.getName());
                }
            });
        });
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRoles(roleList);
        simpleAuthorizationInfo.addStringPermissions(permissionList);
        return simpleAuthorizationInfo;
    }

    /**
     * 用户认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("登录认证 doGetAuthenticationInfo");
        String userName = (String) authenticationToken.getPrincipal();
        User user = userService.findAllUserInfoByUsername(userName);
        String pwd = user.getPassword();
        if (StringUtils.isEmpty(pwd)) {
            throw new IllegalArgumentException("use pwd is null");
        }
        return new SimpleAuthenticationInfo(userName, pwd, this.getClass().getName());
    }
}
