package com.tang.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * 
* @ClassName: User  
* @Description: 用户实体类
* @author (TangGoooo)  
* @date 2018年1月26日 下午3:28:22 
* @version V1.0
 */
public class User {
	 @Id
     @Column(name = "id")
     @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Long age;
	

	public User() {
		super();
	}
	public User(Long id, String name, Long age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
