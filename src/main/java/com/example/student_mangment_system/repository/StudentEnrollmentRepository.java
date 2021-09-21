package com.example.student_mangment_system.repository;

import com.example.student_mangment_system.entities.Course;
import com.example.student_mangment_system.entities.Student;
import com.example.student_mangment_system.entities.StudentEnrolled;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface StudentEnrollmentRepository extends JpaRepository<StudentEnrolled, Long> {
    boolean existsByCourseAndStudent(Course course, Student student);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `join_table` WHERE student_id = ?1 And course_id =?2", nativeQuery = true)
    void deleteByCourseIdAndStudentId(Long studentId, Long courseId);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM `join_table` WHERE student_id = ?1", nativeQuery = true)
    void deleteStudentById(Long studentId);

    boolean existsByStudentStudentId(Long studentId);

    void deleteByCourseId(Long courseId);
}
