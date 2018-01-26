package com.tang.model;

/**
 * 
* @ClassName: User  
* @Description: 用户实体类
* @author (TangGoooo)  
* @date 2018年1月26日 下午3:28:22 
* @version V1.0
 */
public class User {
	private Integer id;
	private String name;
	private Integer age;
	

	public User(Integer id, String name, Integer age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
}
