package com.my.datasource.service;

import com.my.datasource.domain.User;
import com.my.datasource.mapper.UserMapper;
import org.minbox.framework.api.boot.plugin.datasource.annotation.DataSourceSwitch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;


@Service
@DataSourceSwitch("slave_2")
public class UserService2 {
	@Autowired
	private UserMapper userMapper;

	public User findByName(String name) {
		return userMapper.findByName(name);
	}
	@Transactional
	public int insert(String name, String age) {
		String id = UUID.randomUUID().toString();
		int count = userMapper.insert(id, name, age);
		int i = 1 / 0;
		return count;
	}

}
