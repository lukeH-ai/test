package com.my.monitor;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.my.monitor.mapper")
public class AppMonitor {
    public static void main(String[] args) {
        SpringApplication.run(AppMonitor.class, args);
    }
}
