package com.example.student_mangment_system.controller;

import com.example.student_mangment_system.entities.Student;
import com.example.student_mangment_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/student")
    public List<Student> getStudent(){
        return this.studentService.getStudent();
    }

    @PostMapping("/student")
    public Student addStudent(@RequestBody Student student){
        return this.studentService.addStudent(student);
    }

    @PutMapping("/student")
    public Student updateStudent(@RequestBody Student student){
        return  this.studentService.updateStudent(student);
    }

    @DeleteMapping("/student/{studentId}")
    public Student deleteStudent(@PathVariable Long studentId) {
        return  this.studentService.deleteStudent(studentId);
    }

}
