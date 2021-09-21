package com.example.student_mangment_system.service;

import com.example.student_mangment_system.entities.Course;

import java.util.List;

public interface CourseService {

    public List<Course> getCourses();

    public Course addCourses(Course course);

    public Course getOneCourse(Long courseId);

    public Course deleteCourse(Long courseId);

    public Course updateCourse(Course course);
}
