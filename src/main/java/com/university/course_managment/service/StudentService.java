package com.university.course_managment.service;

import com.university.course_managment.entities.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getStudent();

    public Student addStudent(Student student);

    public Student getOneStudent(Long studentId);

    public Student deleteStudent(Long studentId);
}
