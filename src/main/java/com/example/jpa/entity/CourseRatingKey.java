package com.example.jpa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class CourseRatingKey implements Serializable {

	private static final long serialVersionUID = 3336631908077266970L;

	@Column(name = "student_id")
    private Long studentId;

    @Column(name = "course_id")
    private Long courseId;

    public CourseRatingKey() {
    }

    public CourseRatingKey(Long studentId, Long courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }
}
