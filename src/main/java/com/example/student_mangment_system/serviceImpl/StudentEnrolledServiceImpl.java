package com.example.student_mangment_system.serviceImpl;

import com.example.student_mangment_system.entities.StudentEnrolled;
import com.example.student_mangment_system.repository.StudentEnrollmentRepository;
import com.example.student_mangment_system.service.StudentEnrolledService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentEnrolledServiceImpl implements StudentEnrolledService {

    @Autowired
    private StudentEnrollmentRepository repository;

    @Override
    public List<StudentEnrolled> getAllEnrolledStudent() {
        return repository.findAll();
    }

    @Override
    public StudentEnrolled addData(StudentEnrolled studentEnrolled) {

        return repository.save(studentEnrolled);
    }

    @Override
    public StudentEnrolled updateData(StudentEnrolled studentEnrolled) {
        return repository.save(studentEnrolled);
    }

}
