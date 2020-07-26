package com.design.decoration.decorate;

import com.design.UserService;
import com.design.entity.User;

public class AbstractDecorate implements UserService {
    private UserService userService;

    public AbstractDecorate(UserService userService) {
        this.userService = userService;
    }

    public User selectUser(String key) {
        return userService.selectUser(key);
    }
}
