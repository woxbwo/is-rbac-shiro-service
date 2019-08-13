package com.is.shiro.service.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.DefaultSecurityManager;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName: ShiroConfig
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.08.13 15:00
 */
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        System.out.println("执行 ShiroFilterFactoryBean.shiroFilter()");
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //必须设置
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //需要登录的接口，如果访问某个接口，却没登录
        shiroFilterFactoryBean.setLoginUrl("/pub/need_login");
        //登录成功跳转的url
        shiroFilterFactoryBean.setSuccessUrl("/");

        //没权限。未授权调用接口就会跳到此接口 ，先登录-》验证是否有权限

        shiroFilterFactoryBean.setUnauthorizedUrl("/pub/not_permission");

        /**
         * 1.必须使用LinkedHashMap
         * 2.按照顺序执行 /** 必须放在最下边
         */
        Map<String,String> filterChainMap = new LinkedHashMap<>();
        //退出过滤器
        filterChainMap.put("/logout","logout");
        //匿名能访问的，也就是游客可以访问的
        filterChainMap.put("/pub/**","anon");
        //登录才可以操作的
        filterChainMap.put("/user/**","authc");
        //管理员角色才可以访问的
        filterChainMap.put("/admin/***","roles[admin]");
        //有编辑权限才可以访问的
        filterChainMap.put("/video/update","perms[video_update]");
        //authc : url用户必须通过认证才能访问
        //anno  : url可以匿名访问
        filterChainMap.put("/**","authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainMap);
        return shiroFilterFactoryBean;
    }
    @Bean
    public SecurityManager securityManager(){
        DefaultSecurityManager securityManager = new DefaultSecurityManager();

        securityManager.setSessionManager(sessionManager());
        //设置realm，推荐放在最后
        securityManager.setRealm(customRealm());
        return securityManager;
    }
    @Bean
    public CustomRealm customRealm(){
        CustomRealm customRealm = new CustomRealm();
        customRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return customRealm;
    }

    @Bean
    public SessionManager sessionManager(){
        CustomSessionManager customSessionManager = new CustomSessionManager();
        //会话超时时间30分钟
        customSessionManager.setGlobalSessionTimeout(20000);
        return customSessionManager;
    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        //设置三列算法
        hashedCredentialsMatcher.setHashAlgorithmName("sha256");
        //设置散列算法次数
        hashedCredentialsMatcher.setHashIterations(2);
        return hashedCredentialsMatcher;
    }
}
