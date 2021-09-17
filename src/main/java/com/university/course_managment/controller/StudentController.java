package com.university.course_managment.controller;

import com.university.course_managment.entities.Student;
import com.university.course_managment.service.StudentService;
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

    @DeleteMapping("/student/{studentid}")
    public Student deleteStudent(@PathVariable Long studentId){
        return  this.studentService.deleteStudent(studentId);
    }

}
