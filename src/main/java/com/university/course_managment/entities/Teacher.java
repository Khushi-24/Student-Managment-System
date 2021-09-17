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
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "teacher_id")
    private Long id;
    private String name;
//
//    @JsonIgnore
//    @OneToMany
//    @JoinTable(name = "teachers_of_course",
//            joinColumns = @JoinColumn(name = "teacher_id"),
//            inverseJoinColumns = @JoinColumn(name = "course_id"))
//    private Set<Course> courseSet = new HashSet<>();

    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private Set<Course> courseSet = new HashSet<>();
}
