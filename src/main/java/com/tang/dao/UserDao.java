package com.tang.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.tang.entity.User;

@Mapper
public interface UserDao {
	
	public void add(User user);
	
	public User findById(@Param(value="id")long id);
	
	public void delete(@Param(value="id")long id);
	
	public void update(User user);
	
	public List<User> list(@Param(value="name")String name);
	
}