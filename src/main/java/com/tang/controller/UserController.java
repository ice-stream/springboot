package com.tang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tang.core.result.ResultGenerator;
import com.tang.entity.User;
import com.tang.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PostMapping("/")
	public String add(@ModelAttribute User user) {
		userService.add(user);
		return ResultGenerator.successs().toString();
	}

	@GetMapping("/find")
	public String findById(@RequestParam long id) {
		User data =  userService.findById(id);
		return ResultGenerator.successWithData(data).toString();
	}

	@GetMapping("/")
	public String delete(@RequestParam long id) {
		userService.delete(id);
		
		return ResultGenerator.successs().toString();
	};

	@PutMapping("/")
	public String update(@ModelAttribute User user) {
		userService.update(user);
		
		return ResultGenerator.successs().toString();
	}

	@GetMapping("/list")
	public String list(@RequestParam String name) {
		List<User> users = userService.list(name);
		return ResultGenerator.successWithData(users).toString();
	}

}
