package com.example.student_mangment_system.controller;

import com.example.student_mangment_system.dto.CourseDto;
import com.example.student_mangment_system.dto.DeleteCourseDto;
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
    public ResponseEntity<?> getCourse(){
         List<CourseDto> courseList = courseService.getCourses();
         return new ResponseEntity<List<CourseDto>>(courseList, HttpStatus.OK);
    }

    @PostMapping("/courses")
    public ResponseEntity<?> addCourses(@RequestBody CourseDto courseDto){

        CourseDto addCourse= courseService.addCourses(courseDto);
        return new ResponseEntity<CourseDto>(addCourse, HttpStatus.CREATED);

    }

    @PutMapping("/courses")
    public ResponseEntity<CourseDto> updateCourse(@RequestBody CourseDto courseDto){
        CourseDto update_course= courseService.updateCourse(courseDto);
        return new ResponseEntity<CourseDto>(update_course, HttpStatus.CREATED);
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

    @PostMapping("/addStudentAndTeacherToCourse/teacher/student/course")
    public ResponseEntity<?> addStudentAndTeacherToCourse(@RequestBody DeleteCourseDto deleteCourseDto) {
        courseService.addStudentAndTeacherIntoCourse(deleteCourseDto);
        return ResponseEntity.ok("Teacher and Student added successfully.");
    }

//    @GetMapping("/addStudentAndTeacher/{teacherId}/{studentId}/{courseId}")
//    public ResponseEntity<?> addStudentAndTeacherToCourse(@PathVariable("teacherId") Long teacherId, @PathVariable("studentId") Long studentId, @PathVariable("courseId") Long courseId) {
//        courseService.addStudentAndTeacherIntoCourse(teacherId, studentId, courseId);
//        return ResponseEntity.ok("Teacher and Student added successfully.");
//    }


//    @GetMapping("/addStudentAndTeacherToCourse")
//    public ResponseEntity<?> addStudentAndTeacherToCourse(@RequestBody CourseDto courseDto, )

    //    @DeleteMapping("/deleteStudent/{studentId}/{courseId}")
    //    public ResponseEntity<?> deleteStudentFromCourse(@PathVariable("studentId") Long studentId, @PathVariable("courseId") Long courseId){
    //        courseService.deleteStudentFromCourse(studentId, courseId);
    //        return ResponseEntity.ok("Student Deleted From Course Successfully");
    //    }

    @DeleteMapping("/deleteStudentAndTeacher/teacher/student/course")
    public ResponseEntity<?> deleteStudentFromCourse(@RequestBody DeleteCourseDto deleteCourseDto){
        courseService.deleteStudentAndTeacherFromCourse(deleteCourseDto);
        return ResponseEntity.ok("Student And Teacher Deleted From Course Successfully");
    }



    @DeleteMapping("/deleteCourse/{courseId}")
    public ResponseEntity<?> deleteCourseByCourseId(@PathVariable("courseId") Long courseId){
        courseService.deleteCourseByCourseId(courseId);
        return ResponseEntity.ok("Course Deleted from Join Table Successfully");
    }
}