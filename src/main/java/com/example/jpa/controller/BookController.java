package com.example.jpa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.repository.BookRepository;

@RestController
public class BookController {
	
	@Autowired
	private BookRepository bookRepository;
	
	@GetMapping("/books")
	public ResponseEntity<?> getAllBooks() {
		
		// bookRepository.findAll(); if using entity, even the pages is lazy loading, but when call in rest api
		// the data for page, loaded to in response
		
		return ResponseEntity.ok(bookRepository.findAllBookDTO());
	}
}
