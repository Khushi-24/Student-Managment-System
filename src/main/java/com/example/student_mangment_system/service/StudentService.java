package com.example.student_mangment_system.service;

import com.example.student_mangment_system.dto.StudentDto;

import java.util.List;

public interface StudentService {

    public List<StudentDto> getStudent();

    public StudentDto addStudent(StudentDto studentdto);

//    public Student getOneStudent(Long studentId);

    public void deleteStudent(Long studentId);

    public StudentDto updateStudent(StudentDto studentDto);

    void deleteStudentByStudentId(Long studentId);
}
