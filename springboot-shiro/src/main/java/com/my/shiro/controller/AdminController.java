package com.my.shiro.controller;


import com.my.shiro.domain.JsonData;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("admin")
public class AdminController {

    @RequiresPermissions("admin:list")
    @RequestMapping("/video/order")
    public JsonData findMyPlayRecord(){

        Map<String ,String> recordMap = new HashMap<>();

        recordMap.put("SpringBoot入门到高级实战","300元");
        recordMap.put("Cloud微服务入门到高级实战","877元");
        recordMap.put("分布式缓存Redis","990元");

        return JsonData.buildSuccess(recordMap);

    }

}
