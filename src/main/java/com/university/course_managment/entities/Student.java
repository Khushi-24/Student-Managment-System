package com.university.course_managment.entities;

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

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private Long id;

    @Column(name = "First_name")
    private String name;

    @Column(name = "Last_name")
    private String lname;

    @Column(name = "division")
    private String division;

    @JsonIgnore
    @OneToMany(mappedBy = "student")
    private Set<Course> course = new HashSet<>();


}
