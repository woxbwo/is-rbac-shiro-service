package com.is.shiro.service.config;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;

import java.io.Serializable;
import java.util.UUID;

/**
 * @ClassName: CustomsSessionIdGenerator
 * 自定义sessionId的生成器
 * @Description:
 * @Author: Coding_wxb
 * @Date 2019.08.29 0:41
 */
public class CustomsSessionIdGenerator implements SessionIdGenerator {
    @Override
    public Serializable generateId(Session session) {
        return "woxbwo"+ UUID.randomUUID().toString().replace("-","");
    }
}
