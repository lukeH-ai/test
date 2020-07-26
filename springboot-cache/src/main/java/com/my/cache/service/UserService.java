/**
 * Created on 2018/8/11.
 */
package com.my.cache.service;

import com.alicp.jetcache.anno.*;
import com.my.cache.domain.User;

import java.util.concurrent.TimeUnit;

/**
 * @author <a href="mailto:areyouok@gmail.com">huangli</a>
 */
public interface UserService {
    /**
     * 创建方法缓存
     *
     * 具体参考中文文档：https://blog.csdn.net/sinat_32366329/article/details/80260944
     *  @Cached(name="userCache.", key="#userId", expire = 3600) 该注解自动插入缓存
     */

    @Cached(name="userCache.", key="#userId", expire = 3600)
    User getUserById(long userId);

    @CacheUpdate(name="userCache.", key="#user.userId", value="#user")
    void updateUser(User user);

    @CacheInvalidate(name="userCache.", key="#userId")
    void deleteUser(long userId);

    /**
     *具体参考： https://github.com/alibaba/jetcache/wiki/MethodCache_CN
     *
     * @Cached
     *
     * 创建缓存，cacheType = CacheType.REMOTE 指定缓存类型 （依据yml中配置）
     *
     * @CacheRefresh
     *
     * refresh	未定义	刷新间隔
     * timeUnit	TimeUnit.SECONDS	时间单位
     * stopRefreshAfterLastAccess	未定义	指定该key多长时间没有访问就停止刷新，如果不指定会一直刷新
     * refreshLockTimeout	60秒	类型为BOTH/REMOTE的缓存刷新时，同时只会有一台服务器在刷新，这台服务器会在远程缓存放置一个分布式锁，此配置指定该锁的超时时间
     *
     *
     * @CachePenetrationProtect注解：
     *
     * 当缓存访问未命中的情况下，对并发进行的加载行为进行保护。 当前版本实现的是单JVM内的保护，即同一个JVM中同一个key只有一个线程去加载，其它线程等待结果。
     */
//    @Cached(name="userCache.", key="#userId", expire = 3600, cacheType = CacheType.REMOTE)
//    @Cached(name="userCache.", key="#userId", expire = 3600, cacheType = CacheType.LOCAL)
//    @Cached(name="userCache.", key="#userId", expire = 3600, cacheType = CacheType.BOTH)
    @Cached(name="userCache.", key="#userId", expire = 3600, cacheType = CacheType.BOTH)
    @CacheRefresh(refresh = 1800, stopRefreshAfterLastAccess = 3600, timeUnit = TimeUnit.SECONDS)
    @CachePenetrationProtect
    User getUserById2(long userId);
}