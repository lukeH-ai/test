package com.design.decoration.Impl;

import com.design.UserService;
import com.design.decoration.decorate.AbstractDecorate;
import com.design.entity.User;

import java.util.HashMap;
import java.util.Map;

public class TwoCache extends AbstractDecorate {
    private Map cache = new HashMap();

    public TwoCache(UserService userService) {
        super(userService);
    }

    @Override
    public User selectUser(String key) {
        System.out.println(">>>> 查询二级缓存");
        User o = (User) cache.get(key);
        if (o == null) {
            User user = super.selectUser(key);
            if (user != null) {
                cache.put(key,user);
            }
            o = user;
        }
        return o;
    }
}
