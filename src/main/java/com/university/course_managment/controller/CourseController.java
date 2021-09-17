package com.university.course_managment.controller;

import com.university.course_managment.entities.Course;
import com.university.course_managment.entities.Student;
import com.university.course_managment.entities.Teacher;
import com.university.course_managment.service.CourseService;
import com.university.course_managment.service.StudentService;
import com.university.course_managment.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private StudentService studentService;

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/courses")
    public List<Course> getCourse(){
        return  this.courseService.getCourses();
    }

//
//    @GetMapping("course_name")
//    public Course getCourseByName(String course_name){
//        return courseService.getCourseByName(course_name);
//    }

    @PostMapping("/courses")
    public Course addCourses(@RequestBody Course course){
        return  this.courseService.addCourses(course);
    }

    @PutMapping("/courses/{courseId}/student/{studentId}")
    public Course addStudentToCourse(
            @PathVariable Long courseId,
            @PathVariable Long studentId
    ){
        Course course = courseService.getOneCourse(courseId);
        Student student_ = studentService.getOneStudent(studentId);
        course.enrollStudent(student_);
        return courseService.addCourses(course);
    }

    @DeleteMapping("/courses/{courseId}/student/{studentId}")
    public Course deleteStudentFromCourse(@PathVariable Long courseId, @PathVariable Long studentId){
        Course course = courseService.getOneCourse(courseId);
        Student student_ = studentService.getOneStudent(studentId);
        course.removeStudent(student_);
        return course;
    }

    @PutMapping("/courses/{courseId}/teacher/{teacherId}")
    public Course addTeacherToCourse(
            @PathVariable Long courseId,
            @PathVariable Long teacherId
    ){
        Course course = courseService.getOneCourse(courseId);
        Teacher teacher_ = teacherService.getOneteacher(teacherId);
        course.addTeacher(teacher_);
        return courseService.addCourses(course);
    }

}
