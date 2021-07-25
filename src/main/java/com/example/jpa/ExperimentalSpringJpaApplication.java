package com.example.jpa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.jpa.dto.PageDTO;
import com.example.jpa.entity.Address;
import com.example.jpa.entity.Book;
import com.example.jpa.entity.Course;
import com.example.jpa.entity.CourseRating;
import com.example.jpa.entity.CourseRatingKey;
import com.example.jpa.entity.Page;
import com.example.jpa.entity.Student;
import com.example.jpa.entity.User;
import com.example.jpa.repository.AddressRepository;
import com.example.jpa.repository.BookRepository;
import com.example.jpa.repository.CourseRatingRepository;
import com.example.jpa.repository.CourseRepository;
import com.example.jpa.repository.PageRepository;
import com.example.jpa.repository.StudentRepository;
import com.example.jpa.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class ExperimentalSpringJpaApplication implements CommandLineRunner {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private PageRepository pageRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRatingRepository courseRatingRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(ExperimentalSpringJpaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//PLAYING WITH ONE TO MANY
		saveData_ONE_TO_MANY();
		
		getExistingData_ONE_TO_MANY();
		
		getPage_MANY_TO_ONE();
		
		//PLAYING WITH ONE TO ONE WITH SHARED KEY
		saveData_ONE_TO_ONE();
		
		getData_ONE_TO_ONE();
		
		updateData_ONE_TO_ONE();
		
		//PLAYING WITH MANY TO MANY WITH COMPOSITE KEY
		saveData_MANY_TO_MANY();
		
		
        
	}

	@Transactional
	private void saveData_MANY_TO_MANY() {
		System.out.println("==================================saveData_MANY_TO_MANY===============================================");
		Course c1 = new Course("Course A");
		Course c2 = new Course("Course B");
		courseRepository.saveAll(Arrays.asList(c1, c2));
		
		Student s1 = new Student("Student X");
		Student s2 = new Student("Student Y");
		studentRepository.saveAll(Arrays.asList(s1, s2));
		
		CourseRating cr1 = new CourseRating(s1, c1, 8);
		CourseRating cr2 = new CourseRating(s1, c2, 9);
		CourseRating cr3 = new CourseRating(s2, c1, 9);
		courseRatingRepository.saveAll(Arrays.asList(cr1, cr2, cr3));
		System.out.println("=======================================================================================");
	}

	@Transactional
	private void updateData_ONE_TO_ONE() {
		System.out.println("================================updateData_ONE_TO_ONE=======================================");
		User user = userRepository.findById(1L).get();
		
		user.setUserName("new username again");
		userRepository.save(user);
		System.out.println("===================================================================================");
	}

	@Transactional
	private void getData_ONE_TO_ONE() {
		System.out.println("=====================getData_ONE_TO_ONE=============================");
		User user = userRepository.findById(1L).get();
		System.out.println("User : " + user);
		
		user.setUserName("new username");
		userRepository.save(user);
		
		Address address = addressRepository.findById(1L).get();
		System.out.println("Address : " + address);
	}

	private void saveData_ONE_TO_ONE() {
		System.out.println("===========saveData_ONE_TO_ONE=============");
		User user = new User("myusername");
		
		Address address = new Address(user);
		
		//need to save address, even the data null, because we add optional = false in User entity
		//optional = false needed to make fetch type LAZY in one to one relation
		user.setAddress(address);
		userRepository.save(user);
		
	}

	@Transactional
	private void getPage_MANY_TO_ONE() {
		System.out.println("=========================================================================");
		Page page = pageRepository.findById(1L).get();
		
		//YOU CAN ACCESS COLUMN book_id using this way
		System.out.println("Book id : " + page.getBookId());
		
		//Rarely case, but can used this way instead of using eager
		Book book = bookRepository.findById(page.getBookId()).get();
		
		System.out.println("Page : " + page);
		System.out.println("Book : " + book);
		
	}

	@Transactional
	private void getExistingData_ONE_TO_MANY() {
		Book existingBook = bookRepository.findById(1L).get();
		
		//using relation in entity. but this way dosnt work. i dont know why ?
		existingBook.getPages();
		
		//RECOMMENDED WAY
		//select by book, it will produce query like SELECT * FROM Page where bookId = :bookId;
		List<Page> pages2 = pageRepository.findAllByBook(existingBook);
		System.out.println("pages2 : " + pages2);
		
		//RECOMMENDED WAY
		System.out.println("========================================================================");
		List<PageDTO> pagesDTO = pageRepository.findAllPageDTOByBook(existingBook);
		System.out.println("pagesDTO : " + pagesDTO);
		
		
	}

	private void saveData_ONE_TO_MANY() {
		Book book = new Book("Java 101", "John Doe", "123456");
        
        book.addPage(new Page(1, "Introduction contents", "Introduction", book));
        book.addPage(new Page(65, "Java 8 contents", "Java 8", book));
        book.addPage(new Page(95, "Concurrency contents", "Concurrency", book));
        
        
        // save the book
        // with CascadeType.ALL in Book entity. we can save book and page in one line
        bookRepository.save(book);
	}

}
