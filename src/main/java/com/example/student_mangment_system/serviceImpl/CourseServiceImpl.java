package com.example.student_mangment_system.serviceImpl;

import com.example.student_mangment_system.entities.Course;
import com.example.student_mangment_system.repository.CourseRepository;
import com.example.student_mangment_system.service.CourseService;
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

    @Override
    public Course deleteCourse(Long courseId) {
        Course entity = courseRepository.getOne(courseId);
        //System.out.println(entity);
        courseRepository.delete(entity);
        return null;
    }

    @Override
    public Course updateCourse(Course course) {

        courseRepository.save(course);
        return course;
    }

}
