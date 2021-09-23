package com.example.student_mangment_system.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity(name = "course")
@NoArgsConstructor
@Getter
@Setter
public class Course
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name = "courseId")
    private Long courseId;

    @Column(name = "coursename")
    private String coursename;

    @Column(name = "description")
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private Set<StudentEnrolled> studentEnrolledSet = new HashSet<>();

}