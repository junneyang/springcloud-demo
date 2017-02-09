package com.xxx.myproject.myservice.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.xxx.myproject.myservice.user.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
}
