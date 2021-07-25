package com.example.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.jpa.entity.CourseRating;
import com.example.jpa.entity.CourseRatingKey;

@Repository
public interface CourseRatingRepository extends JpaRepository<CourseRating, Long>{

}
