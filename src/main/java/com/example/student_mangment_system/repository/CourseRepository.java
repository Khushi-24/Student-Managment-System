package com.example.student_mangment_system.repository;

import com.example.student_mangment_system.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {
}
