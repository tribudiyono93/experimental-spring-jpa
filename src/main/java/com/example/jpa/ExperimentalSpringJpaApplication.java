package com.example.jpa;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jpa.service.BookService;
import com.example.jpa.service.CourseService;
import com.example.jpa.service.UserService;

@SpringBootApplication
public class ExperimentalSpringJpaApplication implements CommandLineRunner {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CourseService courseService;
	
	public static void main(String[] args) {
		SpringApplication.run(ExperimentalSpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		bookService.saveDataOneToMany();
		
		bookService.getOneToMany();
		
		bookService.getAndUpdateOneToMany();
		
		bookService.getManyToOne();
		
		bookService.getAndUpdateManyToOne();
		
		userService.saveOneToOne();
		
		userService.getOneToOne();
		
		userService.getAndUpdateOneToOne();
		
		courseService.saveManyToMany();
		
		courseService.getManyToMany();
	}
}
