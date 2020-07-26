package com.design.decoration.Impl;

import com.design.UserService;
import com.design.entity.User;

import java.util.HashMap;
import java.util.Map;

public class OneCache implements UserService {
    private Map cache = new HashMap();

    public User selectUser(String key) {
        System.out.println(">>>> 查询一级缓存");
        User o = (User) cache.get(key);
        if (o == null) {
            User user = new User("装饰模式测试", "123456");
            if (user != null) {
                cache.put(key,user);
            }
            o = user;
        }
        return o;
    }
}
