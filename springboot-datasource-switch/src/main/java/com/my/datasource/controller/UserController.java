package com.my.datasource.controller;

import com.my.datasource.domain.User;
import com.my.datasource.service.UserService0;
import com.my.datasource.service.UserService1;
import com.my.datasource.service.UserService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
public class UserController {
    @Autowired
    private UserService0 userService0;

    @Autowired
    private UserService1 userService1;

    @Autowired
    private UserService2 userService2;

    @RequestMapping(value = "/findByName0")
    public User findByName0(String name) {
        System.out.println("name === " + name);
        User user = userService0.findByName(name);
        //System.out.println(user.toString());
        log.info(user.toString());
        return user;
    }

    @RequestMapping(value = "/findByName1")
    public User findByName1(String name) {
        System.out.println("name === " + name);
        User user = userService1.findByName(name);
        //System.out.println(user.toString());
        log.info(user.toString());
        return user;
    }

    @RequestMapping(value = "/findByName2")
    public User findByName2(String name) {
        System.out.println("name === " + name);
        User user = userService2.findByName(name);
        //System.out.println(user.toString());
        log.info(user.toString());
        return user;
    }

    @RequestMapping(value = "/findUser")
    public List findUser() {
        User user0 = userService0.findByName("tome");
        User user1 = userService1.findByName("tome");
        User user2 = userService2.findByName("tome");
        List<User> list = new ArrayList<User>();
        list.add(user0);
        list.add(user1);
        list.add(user2);
        return list;
    }

    @RequestMapping(value = "/insert")
    public String insert(String name, String age) {
        int count0 = userService0.insert(name, age);
        int count1 = userService1.insert(name, age);
        int count2 = userService2.insert(name, age);
        if (count0 > 0 && count1 > 0 && count2 > 0) {
            return "success";
        } else {
            return "fail";
        }
    }

    @RequestMapping(value = "/testTranscation")
    public String testTranscation(String name, String age){
        int count0 = userService0.insert(name, age);
        if (count0 > 0) {
            return "success";
        } else {
            return "fail";
        }
    }

}
