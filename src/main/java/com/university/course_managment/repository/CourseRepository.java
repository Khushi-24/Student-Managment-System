package com.university.course_managment.repository;

import com.university.course_managment.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    //Course findByCourseName(String name);
}
