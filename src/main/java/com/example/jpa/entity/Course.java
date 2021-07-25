package com.example.jpa.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "course")
public class Course {
	
	@Id
    @Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "course", fetch = FetchType.LAZY)
    private Set<CourseRating> ratings;
	
	public Course(String name) {
		this.name = name;
	}
}
