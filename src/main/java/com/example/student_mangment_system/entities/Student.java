package com.example.student_mangment_system.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
@NoArgsConstructor
@Getter
@Setter

@Table(name="student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentId")
    private Long studentId;

    @Column(name = "stname")
    private String stname;

    @Column(name = "division")
    private String division;

    @JsonIgnore
    @OneToMany(mappedBy = "student")
    private Set<StudentEnrolled> studentEnrolledSet = new HashSet<>();

}