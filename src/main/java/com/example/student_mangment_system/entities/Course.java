package com.example.student_mangment_system.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Table(name="course")
public class Course
{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long courseId;
    private String coursename;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "course")
    private Set<StudentEnrolled> studentEnrolledSet = new HashSet<>();

}