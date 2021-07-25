package com.example.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jpa.entity.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>{

}
