package com.jw.spring.ex.jsp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jw.spring.ex.jsp.domain.User;
import com.jw.spring.ex.jsp.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	UserRepository userRepository;
	
	public int addUser(
			String name
			, String birthday
			, String email
			, String introduce) {
		int count = userRepository.insertUser(name, birthday, email, introduce);
		return count;
	}
	public User getLastUser() {
		User user = userRepository.selectLastUser();
		return user;
	}
	
}
