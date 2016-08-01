package com.tianbao54.aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tianbao54.aop.service.AOPService;

@Controller
@RequestMapping("/aop")
public class AOPController {
	
	@Qualifier("aopService")
	@Autowired
	private AOPService aopService;

	@RequestMapping(value = {"/login"},method = RequestMethod.GET)
	public @ResponseBody String login (@RequestParam String username,@RequestParam String password) {
		
		return aopService.userLogin(username, password);
	}
}
