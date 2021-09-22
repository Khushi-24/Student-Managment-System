package com.example.student_mangment_system.controller;

import com.example.student_mangment_system.entities.StudentEnrolled;
import com.example.student_mangment_system.service.CourseService;
import com.example.student_mangment_system.service.StudentEnrolledService;
import com.example.student_mangment_system.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class StudentEnrolledController {

    private final StudentEnrolledService service;

    private final CourseService courseService;

    private final StudentService studentService;

    @PostMapping("/enrollment")
//    @PostMapping("/courses/{courseId}/students/{studentId}")
    public StudentEnrolled retrieveDetailsForCourse(@RequestBody StudentEnrolled studentEnrolled) {
//        Course course = courseService.getOneCourse(courseId);
//        Student student_ = studentService.getOneStudent(studentId);
//        return service.addData(course, student_);
        return service.addData(studentEnrolled);
    }

    @GetMapping("/enrollment")
    public List<StudentEnrolled> getAllEnrolledStudent(){
        return service.getAllEnrolledStudent();
    }

    @PutMapping("/enrollment")
    public StudentEnrolled updateEnrolledStudent(@RequestBody StudentEnrolled studentEnrolled){
        return service.updateData(studentEnrolled);
    }
}

