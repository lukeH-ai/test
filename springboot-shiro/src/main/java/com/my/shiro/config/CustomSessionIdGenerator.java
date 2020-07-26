package com.my.shiro.config;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.SessionIdGenerator;

import java.io.Serializable;
import java.util.UUID;

/**
 *  自定义SessionId生成器
 */
public class CustomSessionIdGenerator implements SessionIdGenerator {
    @Override
    public Serializable generateId(Session session) {
        //可以使用更加复杂的,例如加解密算法等等算法
        return "luke" + UUID.randomUUID().toString().replace("-", "");
    }
}
