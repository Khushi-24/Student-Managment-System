package com.example.student_mangment_system.service;

import com.example.student_mangment_system.entities.Course;
import com.example.student_mangment_system.entities.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getStudent();

    public Student addStudent(Student student);

    public Student getOneStudent(Long studentId);

    public Student deleteStudent(Long studentId);

    public Student updateStudent(Student student);
}
