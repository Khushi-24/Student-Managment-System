package com.example.student_mangment_system.service;

import com.example.student_mangment_system.entities.StudentEnrolled;

import java.util.List;

public interface StudentEnrolledService {

    public List<StudentEnrolled> getAllEnrolledStudent();

    public StudentEnrolled addData(StudentEnrolled studentEnrolled);

    public StudentEnrolled updateData(StudentEnrolled studentEnrolled);
}
