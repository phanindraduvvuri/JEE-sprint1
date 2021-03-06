package com.cg.ams.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.cg.ams.dto.CourseInputDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "course")
public class CourseEntity {

	@Id

	// @GeneratedValue
	private long id;
	@NotEmpty(message = "Name shouldn't be empty")
	private String name;
	private String description;

	// Constructor using fields
	public CourseEntity(long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
	}

	public CourseEntity(CourseInputDTO course) {
		this.id=course.getId();
		this.name=course.getName();
		this.description = course.getDescription();
	}

	@JsonIgnore
	@OneToMany(mappedBy = "course")
	private List<SubjectEntity> subject;
}
