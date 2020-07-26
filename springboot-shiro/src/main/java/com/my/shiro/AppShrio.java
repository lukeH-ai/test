package com.my.shiro;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.my.shiro.mapper")
public class AppShrio {
    public static void main(String[] args) {
        SpringApplication.run(AppShrio.class, args);
    }
}
