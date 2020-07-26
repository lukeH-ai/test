/**
 * Created on 2018/8/11.
 */
package com.my.cache.service;

import com.alicp.jetcache.Cache;
import com.alicp.jetcache.anno.CreateCache;
import com.my.cache.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:areyouok@gmail.com">huangli</a>
 */
@Service
public class MyServiceImpl implements MyService {
    /**
     * 创建缓存实例
     */
    @CreateCache(name = "myServiceCache", expire = 60)
    private Cache<String, String> cache;

    @Autowired
    private UserService userService;

    /**
     * 使用 @CreateCache(name = "myServiceCache", expire = 60) 注解时，
     * 需要手动通过 cache.put("myKey", "myValue"); 进行插入内容
     * @return
     */
    @Override
    public String createCacheDemo() {
        cache.put("myKey", "myValue");
        String myValue = cache.get("myKey");
        System.out.println("get 'myKey' from cache:  " + myValue);
        return myValue;
    }


    @Override
    public User cachedDemo() {
        return userService.getUserById(1);
    }
}