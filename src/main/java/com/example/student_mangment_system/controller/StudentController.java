package com.example.student_mangment_system.controller;

import com.example.student_mangment_system.entities.Student;
import com.example.student_mangment_system.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/student")
    public ResponseEntity<List<Student>> getStudent(){

        List<Student> studentList= studentService.getStudent();
        return new ResponseEntity<List<Student>>(studentList, HttpStatus.OK);
    }

    @PostMapping("/student")
    public ResponseEntity<Student> addStudent(@RequestBody Student student){
        Student student1 = studentService.addStudent(student);
        return new ResponseEntity<Student>(student1, HttpStatus.CREATED);
    }

    @PutMapping("/student")
    public ResponseEntity<Student> updateStudent(@RequestBody Student student){
        Student update_student= studentService.updateStudent(student);
        return new ResponseEntity<Student>(update_student, HttpStatus.CREATED);
    }


//    @DeleteMapping("/student/{studentId}")
//    public  ResponseEntity<?> deleteStudent(@PathVariable Long studentId){
//        studentService.deleteStudent(studentId);
//        return ResponseEntity.ok("Student with studentId= " + studentId + " deleted successfully from all tables.");
//    }

    @DeleteMapping("/deleteStudent/{studentId}")
    public ResponseEntity<?> deleteStudentByStudentId(@PathVariable("studentId") Long studentId){
        studentService.deleteStudentByStudentId(studentId);
        return ResponseEntity.ok("Students Deleted From Course Successfully");
    }
}
