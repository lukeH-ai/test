package com.my.cache;

import com.alicp.jetcache.anno.config.EnableCreateCacheAnnotation;
import com.alicp.jetcache.anno.config.EnableMethodCache;
import com.my.cache.service.MyService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author <a href="mailto:areyouok@gmail.com">huangli</a>
 */
@SpringBootApplication
@EnableMethodCache(basePackages = "com.my.cache")
@EnableCreateCacheAnnotation
public class SpringBootApp {

    public static void main(String[] args) {
//        ConfigurableApplicationContext context = SpringApplication.run(SpringBootApp.class);
//        MyService myService = context.getBean(MyService.class);
//        myService.createCacheDemo();
//        myService.cachedDemo();

        SpringApplication.run(SpringBootApp.class, args);
    }
}
