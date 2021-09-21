package com.example.student_mangment_system.controller;

import com.example.student_mangment_system.service.CourseService;
import com.example.student_mangment_system.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JoinTableController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;


//    @PostMapping("/courses/{courseId}/students/{studentId}")
//    public Student_Enrolled retrieveDetailsForCourse(@PathVariable String studentId,
//                                                     @PathVariable String courseId) {
//        return studentService.addData(studentId, courseId);
//    }


}

