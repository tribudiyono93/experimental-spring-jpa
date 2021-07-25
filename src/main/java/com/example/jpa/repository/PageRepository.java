package com.example.jpa.repository;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.jpa.dto.PageDTO;
import com.example.jpa.entity.Book;
import com.example.jpa.entity.Page;

@Repository
public interface PageRepository extends JpaRepository<Page, Long>{
	//List<Page> findAllByBookId(Long bookId);
	List<Page> findAllByBook(Book book);
	
	@Query("SELECT new com.example.jpa.dto.PageDTO(p.id, p.number, p.content, p.chapter) FROM Page p WHERE p.book = :book")
	List<PageDTO> findAllPageDTOByBook(Book book);
}
