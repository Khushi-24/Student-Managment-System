package com.example.student_mangment_system.service;

import com.example.student_mangment_system.entities.Course;

import java.util.List;

public interface CourseService {

    List<Course> getCourses();

    Course addCourses(Course course);

    void deleteCourse(Long courseId);

    Course updateCourse(Course course);

 //   void addStudentIntoCourse(Long studentId, Long courseId);

    void deleteStudentFromCourse(Long studentId, Long courseId);

    void deleteCourseByCourseId(Long courseId);

    void addStudentAndTeacherIntoCourse(Long teacherId, Long studentId, Long courseId);

    void deleteStudentAndTeacherFromCourse(Long teacherId, Long studentId, Long courseId);
}
