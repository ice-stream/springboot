package com.tang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tang.core.result.ResultGenerator;
import com.tang.model.User;


/** 
* @ClassName: HelloController 
* @Description: 测试mvc是否可以通过
* @author (TangGoooo)  
* @date 2018年1月26日 下午3:06:37 
* @version V1.0 
*/
@Controller
public class HelloController { 
	
	@RequestMapping("/hello")
	@ResponseBody
	public String hello(){
		return "hello world";
	}
	
	@RequestMapping("/user")
	@ResponseBody
	public String returnSucess(){
		
		return ResultGenerator.successs().toString();
	}
	
	@RequestMapping("/getData")
	@ResponseBody
	public String returnSucessWithData(){
		User user = new User(1, "TangGoooo", 24);
		return ResultGenerator.successWithData(user).toString();
	}

}
