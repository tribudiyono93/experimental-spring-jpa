package com.example.jpa.service;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.jpa.dto.PageDTO;
import com.example.jpa.entity.Book;
import com.example.jpa.entity.Page;
import com.example.jpa.repository.BookRepository;
import com.example.jpa.repository.PageRepository;

import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private PageRepository pageRepository;
	
	@Transactional
	public void saveDataOneToMany() {
		log.info("================================start saveDataOneToMany==================================================");
		Book book = new Book("Java 101", "John Doe", "123456");
        
        book.addPage(new Page(1, "Introduction contents", "Introduction", book));
        book.addPage(new Page(65, "Java 8 contents", "Java 8", book));
        book.addPage(new Page(95, "Concurrency contents", "Concurrency", book));
        
        // save the book
        // with CascadeType.ALL in Book entity. we can save book and page in one line
        bookRepository.save(book);
        log.info("================================end saveDataOneToMany==================================================");
	}
	
	@Transactional
	public void getOneToMany() {
		log.info("===========================================start getOneToMany===========================================================");
		Book existingBook = bookRepository.findById(1L).get();
		
		//RECOMMENDED WAY
		//select by book, it will produce query like SELECT * FROM Page where bookId = :bookId;
		//List<Page> pages2 = pageRepository.findAllByBook(existingBook);
		
		//RECOMMENDED WAY
		//List<PageDTO> pagesDTO = pageRepository.findAllPageDTOByBook(existingBook);
		
		//RECOMMENDED WAY
		Set<Page> page3 = existingBook.getPages();
		log.info("Pages : " + page3);
		
		log.info("===========================================end getOneToMany===========================================================");
	}
	
	@Transactional
	public void getAndUpdateOneToMany() {
		log.info("===========================================start getAndUpdateOneToMany===========================================================");
		Book existingBook = bookRepository.findById(1L).get();
		
		existingBook.setAuthor("change author name");
		
		//RECOMMENDED WAY
		//select by book, it will produce query like SELECT * FROM Page where bookId = :bookId;
		//List<Page> pages2 = pageRepository.findAllByBook(existingBook);
		
		//RECOMMENDED WAY
		//List<PageDTO> pagesDTO = pageRepository.findAllPageDTOByBook(existingBook);
		
		//RECOMMENDED WAY
		Set<Page> page3 = existingBook.getPages();
		log.info("Pages : " + page3);
		
		for (Page page : page3) {
			page.setContent("change content page");
		}
		
		//if you are set this cascade = CascadeType.ALL in book entity
		//you can update both book and page using one line
		bookRepository.save(existingBook);
		
		log.info("===========================================end getAndUpdateOneToMany===========================================================");
	}
	
	@Transactional
	public void getManyToOne() {
		log.info("========================================================start getManyToOne=========================================================================");
		Page page = pageRepository.findById(1L).get();
		
		//YOU CAN ACCESS COLUMN book_id using this way
		log.info("Access Book id : " + page.getBookId());
		
		//Rarely case, but can used this way instead of using eager
		//Book book = bookRepository.findById(page.getBookId()).get();
		
		//OR ANOTHER RECOMMENDED WAY
		Book book = page.getBook();
		log.info("Book : " + book.toString());
		log.info("==========================================================end getManyToOne=======================================================================");
	}
	
	@Transactional
	public void getAndUpdateManyToOne() {
		log.info("========================================================start getAndUpdateManyToOne=========================================================================");
		Page page = pageRepository.findById(1L).get();
		page.setContent("updated the content");
		
		//OR ANOTHER RECOMMENDED WAY
		Book book = page.getBook();
		book.setTitle("updated the title");
		
		//if you are set this cascade = CascadeType.ALL in book entity
		//you can update both page and book using one line
		//and if you are only update the page only, the book will not updated. very usefull.
		pageRepository.save(page);
		
		log.info("==========================================================end getAndUpdateManyToOne=======================================================================");
	}
	
}
