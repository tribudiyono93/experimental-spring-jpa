package com.example.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.entity.User;
import com.example.jpa.repository.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void getUser() {
		User user = userRepository.findById(1L).get();
		System.out.println("User : " + user);
		
		System.out.println(user.getAddress());
	}
}
