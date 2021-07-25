package com.example.jpa.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "course_rating", 
	uniqueConstraints = { @UniqueConstraint(columnNames = { "student_id", "course_id" }) })
public class CourseRating {
	//DONT USE THIS
	//@EmbeddedId
	//private CourseRatingKey id;
	
	//USE THIS
	@Id
    @Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "rating")
    private int rating;

    public CourseRating() {
    }
    
    public CourseRating(Student student, Course course, int rating) {
    	this.student = student;
    	this.course = course;
    	this.rating = rating;
    }
}
