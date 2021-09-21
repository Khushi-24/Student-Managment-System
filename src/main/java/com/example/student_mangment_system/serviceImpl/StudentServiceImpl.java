package com.example.student_mangment_system.serviceImpl;

import com.example.student_mangment_system.entities.Course;
import com.example.student_mangment_system.entities.Student;
import com.example.student_mangment_system.repository.StudentRepository;
import com.example.student_mangment_system.service.StudentService;
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

        Student student = studentRepository.getOne(studentId);
        studentRepository.delete(student);
        return null;
    }

    @Override
    public Student updateStudent(Student student) {
        studentRepository.save(student);
        return student;
    }
}
