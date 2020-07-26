package com.devtool.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "测试,你瞅啥，瞅你咋地？就瞅了咋地";
    }

}
