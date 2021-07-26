package com.example.jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.entity.Address;
import com.example.jpa.entity.User;
import com.example.jpa.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public void saveOneToOne() {
		System.out.println();
		System.out.println();
		log.info("===start saveOneToOne===");
		User user = new User("myusername");
		
		Address address = new Address("street", "city", user);
		
		//need to save address, even the data null, because we add optional = false in User entity
		//optional = false needed to make fetch type LAZY in one to one relation
		user.setAddress(address);
		userRepository.save(user);
		log.info("===end saveOneToOne===");
	}
	
	@Transactional
	public void getOneToOne() {
		System.out.println();
		System.out.println();
		log.info("===start getOneToOne===");
		User user = userRepository.findById(1L).get();
		
		System.out.println(user.getAddress());
		log.info("===end getOneToOne===");
	}
	
	@Transactional
	public void getAndUpdateOneToOne() {
		System.out.println();
		System.out.println();
		log.info("===start getAndUpdateOneToOne===");
		User user = userRepository.findById(1L).get();
		
		user.setUserName("another username");
		
		
		Address address = user.getAddress();
		
		address.setCity("another city");
		
		userRepository.save(user);
		log.info("===end getAndUpdateOneToOne===");
	}
}
