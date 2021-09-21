package com.example.student_mangment_system.controller;

import com.example.student_mangment_system.entities.Course;
import com.example.student_mangment_system.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
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
}