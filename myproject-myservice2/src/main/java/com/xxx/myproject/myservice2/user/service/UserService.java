package com.xxx.myproject.myservice2.user.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.xxx.myproject.myservice2.user.entity.User;

@Service
public class UserService {
	@Autowired
	private RestTemplate restTemplate;
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);
	
	@HystrixCommand(fallbackMethod = "fallback")
	public User getUser(Long id) {
		User user =  this.restTemplate.getForObject("http://myproject-myservice/user/" + id, User.class);
		LOGGER.info(user.toString());
		user.setUsername(user.getUsername() + "_TEST");
		user.setAge(user.getAge() + 100);
		LOGGER.info(user.toString());
		return user;
	}
	
	public User fallback(Long id) {
		LOGGER.info("异常发生，进入fallback方法，接收的参数：id = {}", id);
		User user = new User();
		user.setId(-1L);
	    user.setUsername("default username");
	    user.setAge(0);
	    return user;
	}
}
