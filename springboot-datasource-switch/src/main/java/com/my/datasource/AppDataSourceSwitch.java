package com.my.datasource;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.my.datasource.mapper")
public class AppDataSourceSwitch {
    public static void main(String[] args) {
        SpringApplication.run(AppDataSourceSwitch.class, args);
    }
}
