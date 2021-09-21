package com.example.student_mangment_system.controller;

import com.example.student_mangment_system.entities.Course;
import com.example.student_mangment_system.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @GetMapping("/courses")
    public List<Course> getCourse(){
        return  this.courseService.getCourses();
    }

    @PostMapping("/courses")
    public Course addCourses(@RequestBody Course course){
        return  this.courseService.addCourses(course);
    }

    @PutMapping("/courses")
    public Course updateCourse(@RequestBody Course course){
        return  this.courseService.updateCourse(course);
    }
    @DeleteMapping("/courses/{courseId}")
    public Course deleteCourse(@PathVariable Long courseId){
        return  this.courseService.deleteCourse(courseId);
    }

    // adding student to course
    @GetMapping("/addStudent/{studentId}/{courseId}")
    public ResponseEntity<?> addStudentIntoCourse(@PathVariable("studentId") Long studentId, @PathVariable("courseId") Long courseId) {
        courseService.addStudentIntoCourse(studentId, courseId);
        return ResponseEntity.ok("Student added successfully.");
    }

    @DeleteMapping("/deleteStudent/{studentId}/{courseId}")
    public ResponseEntity<?> deleteStudentFromCourse(@PathVariable("studentId") Long studentId, @PathVariable("courseId") Long courseId){
        courseService.deleteStudentFromCourse(studentId, courseId);
        return ResponseEntity.ok("Student Deleted From Course Successfully");
    }

    @DeleteMapping("/deleteStudent/{studentId}")
    public ResponseEntity<?> deleteStudentByStudentId(@PathVariable("studentId") Long studentId){
        courseService.deleteStudentByStudentId(studentId);
        return ResponseEntity.ok("Students Deleted From Course Successfully");
    }

    @DeleteMapping("/deleteCourse/{courseId}")
    public ResponseEntity<?> deleteCourseByCourseId(@PathVariable("courseId") Long courseId){
        courseService.deleteCourseByCourseId(courseId);
        return ResponseEntity.ok("Course Deleted from Join Table Successfully");
    }
}