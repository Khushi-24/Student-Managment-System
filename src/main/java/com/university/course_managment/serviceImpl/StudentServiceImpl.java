package com.university.course_managment.serviceImpl;

import com.university.course_managment.entities.Student;
import com.university.course_managment.repository.StudentRepository;
import com.university.course_managment.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getOneStudent(Long studentId) {
        Student student = studentRepository.findById(studentId).get();
        return student;
    }

    @Override
    public Student deleteStudent(Long studentId) {

        Student student = studentRepository.findById(studentId).get();
        studentRepository.delete(student);
        return null;
    }
}
