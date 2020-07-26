package com.my.cache.controller;

import com.my.cache.domain.User;
import com.my.cache.service.MyService;
import com.my.cache.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @Autowired
    private MyService myService;

    @Autowired
    private UserService userService;

    @GetMapping("/createCacheDemo")
    public String createCacheDemo(){
        return myService.createCacheDemo();
    }

    @GetMapping("/cachedDemo")
    public User cachedDemo(){
        return myService.cachedDemo();
    }
    @GetMapping("/updateDemo")
    public void updateDemo(){
        User user = new User();
        user.setUserId(1);
        user.setUserName("更新用户名");
        userService.updateUser(user);
    }

    @GetMapping("/deleteDemo")
    public void deleteDemo(){
        userService.deleteUser(1);
    }

    @GetMapping("/getUserById2")
    public User getUserById2(){
        return userService.getUserById2(1);
    }
}
