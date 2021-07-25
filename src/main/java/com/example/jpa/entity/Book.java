package com.example.jpa.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6842483162869129578L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String author;
	@Column(unique = true)
	private String isbn;

	@OneToMany(mappedBy = "book", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Page> pages = new HashSet<>();

	public Book() {
	}

	public Book(String title, String author, String isbn) {
		this.setTitle(title);
		this.author = author;
		this.isbn = isbn;
	}

	/*
	 * public Long getId() { return id; }
	 * 
	 * public void setId(Long id) { this.id = id; }
	 * 
	 * public String getTitle() { return title; }
	 * 
	 * public void setTitle(String title) { this.title = title; }
	 * 
	 * public String getAuthor() { return author; }
	 * 
	 * public void setAuthor(String author) { this.author = author; }
	 * 
	 * public String getIsbn() { return isbn; }
	 * 
	 * public void setIsbn(String isbn) { this.isbn = isbn; }
	 * 
	 * public Set<Page> getPages() { return pages; }
	 * 
	 * public void setPages(Set<Page> pages) { this.pages = pages; }
	 * 
	 * public void addPage(Page page) { pages.add(page); }
	 */

	@Override
	public String toString() {
		return "Book [id=" + id + ", title=" + title + ", author=" + author + ", isbn=" + isbn + "]";
	}

}