package com.example.jpa.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpa.entity.Course;
import com.example.jpa.entity.CourseRating;
import com.example.jpa.entity.Student;
import com.example.jpa.repository.CourseRatingRepository;
import com.example.jpa.repository.CourseRepository;
import com.example.jpa.repository.StudentRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CourseService {
	
	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private CourseRatingRepository courseRatingRepository;
	
	@Transactional
	public void saveManyToMany() {
		System.out.println();
		System.out.println();
		log.info("===start saveManyToMany===");
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
		log.info("===end saveManyToMany===");
	}
	
	@Transactional
	public void getManyToMany() {
		System.out.println();
		System.out.println();
		log.info("===start getManyToMany===");
		Course course = courseRepository.findById(1L).get();
		List<Student> students = studentRepository.findAllByCourse(course);
		log.info("students = " + students);
		log.info("===end getManyToMany===");
	}
}
