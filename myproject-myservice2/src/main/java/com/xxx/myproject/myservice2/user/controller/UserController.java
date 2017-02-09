package com.xxx.myproject.myservice2.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xxx.myproject.myservice2.user.entity.User;
import com.xxx.myproject.myservice2.user.service.UserService;

@RestController
@RequestMapping("/user2")
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public User getUser(@PathVariable("id") Long id) {
		return this.userService.getUser(id);
	}
}
