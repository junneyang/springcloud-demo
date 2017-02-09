package com.xxx.myproject.myservice.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.xxx.myproject.myservice.user.domain.User;
import com.xxx.myproject.myservice.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private DiscoveryClient discoveryClient;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public User getUser(@PathVariable("id") Long id) {
		return this.userService.getUser(id);
	}
	
	@RequestMapping(value="/serviceinfo", method=RequestMethod.GET)
	public ServiceInstance getInfo() {
		return this.discoveryClient.getLocalServiceInstance();
	}
}
