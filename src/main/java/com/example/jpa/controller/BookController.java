package com.example.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.service.BookService;

@RestController
@RequestMapping("book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("/save-one-to-many")
	public ResponseEntity<?> saveOneToMany() {
		bookService.saveDataOneToMany();
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/get-one-to-many")
	public ResponseEntity<?> getOneToMany() {
		bookService.getOneToMany();
		return ResponseEntity.ok().build();
	}
}
