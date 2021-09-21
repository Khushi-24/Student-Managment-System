package com.example.student_mangment_system.entities;

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
    private Long id;
    private String coursename;
    private String description;

    @OneToMany(mappedBy = "course")
    private Set<Student_Enrolled> studentEnrolledSet = new HashSet<>();

}