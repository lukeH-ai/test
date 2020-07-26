package com.design.proxy.Impl;

import com.design.UserService;
import com.design.entity.User;

public class UserServiceImpl implements UserService {
    public User selectUser(String key) {
        return new User("测试代理模式01","111111");
    }
}
