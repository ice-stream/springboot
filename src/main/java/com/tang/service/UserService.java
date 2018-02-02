package com.tang.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tang.dao.UserDao;
import com.tang.entity.User;

import tk.mybatis.mapper.entity.Condition;

@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
    public void add(User user){
    	userDao.insert(user);
    }
	
	public User findById(Long id){
	  return userDao.selectByPrimaryKey(id);
	}
	
	public void delete(long id){
	    userDao.deleteByPrimaryKey(id);
	};
	
	public void update(User user){
		userDao.updateByPrimaryKey(user);
	}
	
	public List<User> list(String name){
		Condition condition=new Condition(User.class);
        condition.createCriteria().andLike("name", name);
        condition.setOrderByClause(" age desc");
		return userDao.selectByCondition(condition);
	}

	public List<User> getUsers() {
		return userDao.selectAll();
	}
	
	public static void main(String[] args) {
		String name  = "tang";
		String str = "name like "+"'%" + name + "%'";
		System.out.println(str);
	}
}
