package com.university.course_managment.service;

import com.university.course_managment.entities.Course;

import java.util.List;

public interface CourseService {

    public List<Course> getCourses();

    public Course addCourses(Course course);

    public Course getOneCourse(Long courseId);

    //public Course getCourseByName(String course_name);
}
