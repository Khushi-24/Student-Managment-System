package com.university.course_managment.serviceImpl;

import com.university.course_managment.entities.Course;
import com.university.course_managment.repository.CourseRepository;
import com.university.course_managment.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public List<Course> getCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course addCourses(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course getOneCourse(Long courseId) {
        Course entity = courseRepository.findById(courseId).get();
        return entity;
    }
//
//    @Override
//    public Course getCourseByName(String name) {
//        return courseRepository.findByCourseName(name);
//    }
}
