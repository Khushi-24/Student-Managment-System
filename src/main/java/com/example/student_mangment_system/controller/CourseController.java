package com.example.student_mangment_system.controller;

import com.example.student_mangment_system.entities.Course;
import com.example.student_mangment_system.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CourseController {

    private final CourseService courseService;

    @GetMapping("/courses")
    public ResponseEntity<List<Course>> getCourse(){
         List<Course> courseList = courseService.getCourses();
         return new ResponseEntity<List<Course>>(courseList, HttpStatus.OK);
    }

    @PostMapping("/courses")
    public ResponseEntity<?> addCourses(@RequestBody Course course){

        Course addCourse= courseService.addCourses(course);
        return new ResponseEntity<Course>(addCourse, HttpStatus.CREATED);

    }

    @PutMapping("/courses")
    public ResponseEntity<Course> updateCourse(@RequestBody Course course){
        Course update_course= courseService.updateCourse(course);
        return new ResponseEntity<Course>(update_course, HttpStatus.CREATED);
    }

//    @DeleteMapping("/courses/{courseId}")
//    public Course deleteCourse(@PathVariable Long courseId){
//        return  this.courseService.deleteCourse(courseId);
//    }

    @DeleteMapping("courses/{courseId}")
    public ResponseEntity<?> deleteCourse(@PathVariable Long courseId){
        courseService.deleteCourse(courseId);
        return ResponseEntity.ok("Course with courseId= " + courseId + " deleted successfully from all tables.");
    }


    // adding student to course
//    @GetMapping("/addStudent/{studentId}/{courseId}")
//    public ResponseEntity<?> addStudentIntoCourse(@PathVariable("studentId") Long studentId, @PathVariable("courseId") Long courseId) {
//        courseService.addStudentIntoCourse(studentId, courseId);
//        return ResponseEntity.ok("Student added successfully.");
//    }

    @GetMapping("/addStudentAndTeacher/{teacherId}/{studentId}/{courseId}")
    public ResponseEntity<?> addStudentIntoCourse(@PathVariable("teacherId") Long teacherId, @PathVariable("studentId") Long studentId, @PathVariable("courseId") Long courseId) {
        courseService.addStudentAndTeacherIntoCourse(teacherId, studentId, courseId);
        return ResponseEntity.ok("Teacher and Student added successfully.");
    }

    @DeleteMapping("/deleteStudent/{studentId}/{courseId}")
    public ResponseEntity<?> deleteStudentFromCourse(@PathVariable("studentId") Long studentId, @PathVariable("courseId") Long courseId){
        courseService.deleteStudentFromCourse(studentId, courseId);
        return ResponseEntity.ok("Student Deleted From Course Successfully");
    }

    @DeleteMapping("/deleteStudentAndTeacher/{teacherId}/{studentId}/{courseId}")
    public ResponseEntity<?> deleteStudentFromCourse(@PathVariable("teacherId") Long teacherId, @PathVariable("studentId") Long studentId, @PathVariable("courseId") Long courseId){
        courseService.deleteStudentAndTeacherFromCourse(teacherId, studentId, courseId);
        return ResponseEntity.ok("Student And Teacher Deleted From Course Successfully");
    }



    @DeleteMapping("/deleteCourse/{courseId}")
    public ResponseEntity<?> deleteCourseByCourseId(@PathVariable("courseId") Long courseId){
        courseService.deleteCourseByCourseId(courseId);
        return ResponseEntity.ok("Course Deleted from Join Table Successfully");
    }
}