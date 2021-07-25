package com.example.jpa.dto;

import javax.persistence.Column;

public class BookDTO {
	private Long id;
	private String title;
	private String author;
	private String isbn;
	
	public BookDTO() {
		
	}

	public BookDTO(Long id, String title, String author, String isbn) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.isbn = isbn;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	@Override
	public String toString() {
		return "BookDTO [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + "]";
	}
	
	
}
