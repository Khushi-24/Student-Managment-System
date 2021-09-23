package com.example.student_mangment_system.controller;

import com.example.student_mangment_system.dto.StudentDto;
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
    public ResponseEntity<List<StudentDto>> getStudent(){

        List<StudentDto> studentList= studentService.getStudent();
        return new ResponseEntity<List<StudentDto>>(studentList, HttpStatus.OK);
    }

    @PostMapping("/student")
    public ResponseEntity<StudentDto> addStudent(@RequestBody StudentDto studentDto){
        StudentDto studentDto1 = studentService.addStudent(studentDto);
        return new ResponseEntity<StudentDto>(studentDto, HttpStatus.CREATED);
    }

    @PutMapping("/student")
    public ResponseEntity<StudentDto> updateStudent(@RequestBody StudentDto studentDto){
        StudentDto update_student= studentService.updateStudent(studentDto);
        return new ResponseEntity<StudentDto>(studentDto, HttpStatus.CREATED);
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
