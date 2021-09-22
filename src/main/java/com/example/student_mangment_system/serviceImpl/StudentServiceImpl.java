package com.example.student_mangment_system.serviceImpl;

import com.example.student_mangment_system.customException.BadRequestException;
import com.example.student_mangment_system.customException.NoRecordFoundException;
import com.example.student_mangment_system.entities.Student;
import com.example.student_mangment_system.repository.StudentEnrollmentRepository;
import com.example.student_mangment_system.repository.StudentRepository;
import com.example.student_mangment_system.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final StudentEnrollmentRepository studentEnrollmentRepository;

    @Override
    public List<Student> getStudent() {
        List<Student> student = studentRepository.findAll();
        if(student.isEmpty()){
            throw  new NoRecordFoundException("Student list is empty.");
        }
        else{
            return student;
        }
    }

    @Override
    public Student addStudent(Student student) {

        if(student.getStname().isEmpty() || student.getStname().isBlank()){
            throw new BadRequestException("Please Enter a valid name.");
        }
        if(student.getDivision().isEmpty() || student.getDivision().isBlank()){
            throw new BadRequestException("Please provide division of student");
        }
        else{
            return studentRepository.save(student);
        }

    }

//    @Override
//    public Student getOneStudent(Long studentId) {
//        Student student = studentRepository.findById(studentId).get();
//        return student;
//    }

    @Override
    public Student updateStudent(Student student) {
        if(student.getStname().isEmpty() || student.getStname().isBlank()){
            throw new BadRequestException("Please Enter a valid name.");
        }
        if(student.getDivision().isEmpty() || student.getDivision().isBlank()){
            throw new BadRequestException("Please provide division of student");
        }
        else{
            studentRepository.save(student);
            return student;
        }
    }

    @Override
    public void deleteStudent(Long studentId) {
        if(studentId == null){
            throw new BadRequestException("Id can't be null.");
        }
        else{
            deleteStudentByStudentId(studentId);
            Student student = studentRepository.getOne(studentId);
            studentRepository.delete(student);
        }

    }

    @Override
    public void deleteStudentByStudentId(Long studentId) {
        if(studentId == null){
            throw new BadRequestException("Id can't be null.");
        }
        else{
            Student student = studentRepository.findById(studentId).orElseThrow(() -> new EntityNotFoundException("Student does not exist."));
            //       StudentEnrolled studentEnrolled = new StudentEnrolled(student);
            if (studentEnrollmentRepository.existsByStudentStudentId(studentId)) {
                studentEnrollmentRepository.deleteStudentById(studentId);
            } else {
                throw new EntityNotFoundException("Student with" + studentId + "Doesn't Exists");
            }
        }

        //System.out.println(studentId);
    }
}
