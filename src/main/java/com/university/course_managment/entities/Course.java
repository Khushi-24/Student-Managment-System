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

public class Course {

    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "course_name")
    private String name;

    @Column(name = "description")
    private String description;

   // @JsonIgnore
    @OneToMany
    @JoinTable(name = "student_enrolled",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "student_id"))
    private Set<Student> student = new HashSet<>();

    public void enrollStudent(Student student_) {
        student.add(student_);
    }

//    @OneToMany(mappedBy = "courseSet")
//    private Teacher teacher;
//    private Set<Teacher> teacher = new HashSet<>() ;

//    @JsonIgnore
    @OneToMany
    @JoinTable(name = "teachers_of_course",
            joinColumns = @JoinColumn(name = "course_id"),
            inverseJoinColumns = @JoinColumn(name = "teacher_id"))
    private Set<Teacher> teacher = new HashSet<>() ;

    public void addTeacher(Teacher teacher_) {
        teacher.add(teacher_);
    }

    public void removeStudent(Student student_) {
        Student deleteStudent = new Student() ;
        for(Student s: student){
            if(s.getId().equals(student_.getId())){
                deleteStudent =s;
            }
        }
        if(deleteStudent != null){
            student.remove(deleteStudent);
        }
//        student.remove(student_);

    }
}
