package com.example.student_mangment_system.service;

import com.example.student_mangment_system.dto.CourseDto;
import com.example.student_mangment_system.dto.DeleteCourseDto;

import java.util.List;

public interface CourseService {

    List<CourseDto> getCourses();

    CourseDto addCourses(CourseDto courseDto);

    void deleteCourse(Long courseId);

    CourseDto updateCourse(CourseDto courseDto);

 //   void addStudentIntoCourse(Long studentId, Long courseId);

//    void deleteStudentFromCourse(Long studentId, Long courseId);

    void deleteCourseByCourseId(Long courseId);

    void addStudentAndTeacherIntoCourse(DeleteCourseDto deleteCourseDto);

    void deleteStudentAndTeacherFromCourse(DeleteCourseDto deleteCourseDto);
}
