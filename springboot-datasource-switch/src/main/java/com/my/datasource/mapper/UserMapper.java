package com.my.datasource.mapper;


import com.my.datasource.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
	public User findByName(String name);
	public int insert(@Param("id") String id, @Param("name") String name, @Param("age") String age);
}
