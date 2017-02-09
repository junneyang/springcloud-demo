package com.xxx.myproject.myservice.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xxx.myproject.myservice.user.domain.User;
import com.xxx.myproject.myservice.user.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	public User getUser(Long id) {
		User user = this.userRepository.findOne(id);
		return user;
	}
}
