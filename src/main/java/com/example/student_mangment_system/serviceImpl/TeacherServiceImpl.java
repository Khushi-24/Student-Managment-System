package com.example.student_mangment_system.serviceImpl;

import com.example.student_mangment_system.customException.BadRequestException;
import com.example.student_mangment_system.customException.NoRecordFoundException;
import com.example.student_mangment_system.entities.Teacher;
import com.example.student_mangment_system.repository.StudentEnrollmentRepository;
import com.example.student_mangment_system.repository.TeacherRepository;
import com.example.student_mangment_system.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    private final StudentEnrollmentRepository studentEnrollmentRepository;

    @Override
    public List<Teacher> getTeachers() {
        List<Teacher> teacher= teacherRepository.findAll();
        if(teacher.isEmpty()){
            throw new NoRecordFoundException("Teacher list is empty");
        }
        else {
            return teacher;
        }
    }

    @Override
    public Teacher addTeacher(Teacher teacher) {
        if(teacher.getName().isEmpty() || teacher.getName().isBlank()){
            throw new BadRequestException("Please enter teacher name.");
        }
        else{
            return teacherRepository.save(teacher);
        }
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        if(teacher.getName().isEmpty() || teacher.getName().isBlank()){
            throw new BadRequestException("Please enter teacher name.");
        }
        else{
            return teacherRepository.save(teacher);
        }
    }

    @Override
    public Teacher deleteTeacher(Long teacherId) {
        if(teacherId == null){
            throw new BadRequestException("Id can't be null");
        }
        else{
            Teacher teacher1 = teacherRepository.findById(teacherId).orElseThrow(() -> new EntityNotFoundException("Teacher does not exist."));
            deleteTeacherfromJoinTable(teacherId);
            Teacher teacher = teacherRepository.getOne(teacherId);
            teacherRepository.delete(teacher);
        }

        return null;
    }

    @Override
    public void deleteTeacherfromJoinTable(Long teacherId) {
        if(teacherId == null){
            throw new BadRequestException("Id can't be null");
        }
        else {
            Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() -> new EntityNotFoundException("Teacher does not exist."));
            studentEnrollmentRepository.deleteByTeacherId(teacherId);
        }
    }
}
