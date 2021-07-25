package com.example.jpa.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "books")
public class Book implements Serializable {

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

	public Book(String title, String author, String isbn) {
		this.setTitle(title);
		this.author = author;
		this.isbn = isbn;
	}
	
	public void addPage(Page page) {
		pages.add(page);
	}
}