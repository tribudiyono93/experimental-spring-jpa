package com.example.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.jpa.dto.BookDTO;
import com.example.jpa.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long>{
	Book findByIsbn(String isbn);
	
	@Query("SELECT new com.example.jpa.dto.BookDTO(b.id, b.title, b.author, b.isbn) FROM Book b")
	List<BookDTO> findAllBookDTO();
	
}
