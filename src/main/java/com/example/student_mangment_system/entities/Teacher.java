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
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name = "teacherId")
    private Long teacherId;

    @Column(name = "name")
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "teacher")
    private Set<StudentEnrolled> studentEnrolledSet = new HashSet<>();

}