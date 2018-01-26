package com.tang.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tang.dao.UserDao;
import com.tang.entity.User;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
    public void add(User user){
    	userDao.add(user);
    }
	
	public User findById(long id){
	  return userDao.findById(id);
	}
	
	public void delete(long id){
	    userDao.delete(id);
	};
	
	public void update(User user){
		userDao.update(user);
	}
	
	public List<User> list(String name){
		return userDao.list(name);
	}
}
