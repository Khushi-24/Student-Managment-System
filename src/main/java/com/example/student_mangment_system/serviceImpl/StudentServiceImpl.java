package com.example.student_mangment_system.serviceImpl;

import com.example.student_mangment_system.customException.BadRequestException;
import com.example.student_mangment_system.customException.NoRecordFoundException;
import com.example.student_mangment_system.dto.StudentDto;
import com.example.student_mangment_system.entities.Student;
import com.example.student_mangment_system.repository.StudentEnrollmentRepository;
import com.example.student_mangment_system.repository.StudentRepository;
import com.example.student_mangment_system.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    private final StudentEnrollmentRepository studentEnrollmentRepository;

    @Override
    public List<StudentDto> getStudent() {
        List<StudentDto> studentDtoList = studentRepository.findAll().stream().map(student ->{
                StudentDto studentDto = new StudentDto();
        studentDto.setStudentId(student.getStudentId());
        studentDto.setStname(student.getStname());
        studentDto.setDivision(student.getDivision());
        return studentDto;
        }).collect(Collectors.toList());
        if(studentDtoList.isEmpty()){
            throw  new NoRecordFoundException("Student list is empty.");
        }
        else{
            return studentDtoList;
        }
    }


    @Override
    public StudentDto addStudent(StudentDto studentDto) {
        Student student;
        if(studentDto.getStname().isEmpty() || studentDto.getStname().isBlank()){
            throw new BadRequestException("Please Enter a valid name.");
        }
        if(studentDto.getDivision().isEmpty() || studentDto.getDivision().isBlank()){
            throw new BadRequestException("Please provide division of student");
        }
        else{
            student = new Student();
            student.setStudentId(studentDto.getStudentId());
            student.setStname(studentDto.getStname());
            student.setDivision(studentDto.getDivision());
            studentRepository.save(student);
            return null;
        }

    }

//    @Override
//    public Student getOneStudent(Long studentId) {
//        Student student = studentRepository.findById(studentId).get();
//        return student;
//    }

    @Override
    public StudentDto updateStudent(StudentDto studentDto) {
        Student student;
        if(studentDto.getStname().isEmpty() || studentDto.getStname().isBlank()){
            throw new BadRequestException("Please Enter a valid name.");
        }
        if(studentDto.getDivision().isEmpty() || studentDto.getDivision().isBlank()){
            throw new BadRequestException("Please provide division of student");
        }
        else{
            student = new Student();
            student.setStudentId(studentDto.getStudentId());
            student.setStname(studentDto.getStname());
            student.setDivision(studentDto.getDivision());
            studentRepository.save(student);
            return null;
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
