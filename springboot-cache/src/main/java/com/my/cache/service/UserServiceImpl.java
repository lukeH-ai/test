/**
 * Created on 2018/8/11.
 */
package com.my.cache.service;

import com.my.cache.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:areyouok@gmail.com">huangli</a>
 */
@Service
public class UserServiceImpl implements UserService {

    @Override
    public User getUserById(long userId) {
        System.out.println("load user: " + userId);
        User user = new User();
        user.setUserId(userId);
        user.setUserName("user" + userId);
        return user;
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(long userId) {

    }

    @Override
    public User getUserById2(long userId) {
        User user = new User();
        user.setUserId(userId);
        user.setUserName("user" + userId);
        return user;
    }
}