package com.tang.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tang.core.result.ResultGenerator;
import com.tang.entity.User;
import com.tang.redis.IRedisService;
import com.tang.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private IRedisService redisService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public String add(User user) {
		userService.add(user);
		return ResultGenerator.successs().toString();
	}

	@GetMapping("/find")
	public String findById(@RequestParam long id) {
		User data = userService.findById(id);
		return ResultGenerator.successWithData(data).toString();
	}

	@GetMapping("/delete")
	public String delete(@RequestParam long id) {
		userService.delete(id);

		return ResultGenerator.successs().toString();
	};

	@PutMapping("/update")
	public String update(@ModelAttribute User user) {
		userService.update(user);

		return ResultGenerator.successs().toString();
	}

	@GetMapping("/list")
	public String list(@RequestParam String name) {
		List<User> users = userService.list(name);
		return ResultGenerator.successWithData(users).toString();
	}

	@RequestMapping("/userbypage")
	public PageInfo<User> test() {
		/*
		 * 第一个参数是第几页；第二个参数是每页显示条数。
		 */
		PageHelper.startPage(1, 1);
		List<User> list = userService.getUsers();
		PageInfo<User> pageInfo = new PageInfo<User>(list);
		return pageInfo;

	}

	@RequestMapping("/redis/set")
	public String redisSet(@RequestParam("value") String value) {
		boolean isOk = redisService.set("name", value);
		return ResultGenerator.successWithData(isOk).toString();
	}

	@RequestMapping("/redis/get")
	public String redisGet() {
		String name = redisService.get("name");
		return ResultGenerator.successWithData(name).toString();
	}
	@RequestMapping("/redis/setList")
	public String redisSetList() {
		List<User> list = new ArrayList<User>();
		list.add(new User(1L, "tang", 23L));
		list.add(new User(1L, "tang1", 123L));
		boolean isok = redisService.setList("list", list);
		return ResultGenerator.successWithData(isok).toString();
	}
	
	@RequestMapping("/redis/getList")
	public String redisGetList() {
		List<User>  data = redisService.getList("list", User.class);
		return ResultGenerator.successWithData(data).toString();
	}
	
	@RequestMapping("/redis/setObj")
	public String redissetObj() {
		Long isok = redisService.lpush("user",new User(1L, "tang", 23L));
		return ResultGenerator.successWithData(isok).toString();
	}

}
