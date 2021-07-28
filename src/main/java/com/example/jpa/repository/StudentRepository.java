package com.example.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.jpa.entity.Course;
import com.example.jpa.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	@Query("SELECT s FROM Student s LEFT JOIN CourseRating c ON s.id = c.student.id WHERE c.course = :course")
	List<Student> findAllByCourse(Course course);
}
