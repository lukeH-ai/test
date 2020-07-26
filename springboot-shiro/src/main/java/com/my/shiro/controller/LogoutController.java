package com.my.shiro.controller;


import org.springframework.web.bind.annotation.RestController;

/**
 * logout, 映射shiro自带的过滤器
 * 这里也可以不用配置logout,因为shiro已经处理了:当请求/logout接口时,会清空sessionId,然后再次调用login登录的接口
 *
 */
@RestController
public class LogoutController {
//
//
//    @RequestMapping("/logout")
//    public JsonData findMyPlayRecord(){
//
//        Subject subject = SecurityUtils.getSubject();
//
//        if(subject.getPrincipals() != null ){
//
//        }
//
//        SecurityUtils.getSubject().logout();
//
//        return JsonData.buildSuccess("logout成功");
//
//    }

}
