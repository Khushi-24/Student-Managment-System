package com.example.student_mangment_system.serviceImpl;

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
        return teacherRepository.findAll();
    }

    @Override
    public Teacher addTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher getOneteacher(Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId).get();
        return teacher;
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher deleteTeacher(Long teacherId) {
        Teacher teacher1 = teacherRepository.findById(teacherId).orElseThrow(() -> new EntityNotFoundException("Teacher does not exist."));
        deleteTeacherfromJoinTable(teacherId);
        Teacher teacher = teacherRepository.getOne(teacherId);
        teacherRepository.delete(teacher);
        return null;
    }

    @Override
    public void deleteTeacherfromJoinTable(Long teacherId) {
        Teacher teacher = teacherRepository.findById(teacherId).orElseThrow(() -> new EntityNotFoundException("Teacher does not exist."));
        studentEnrollmentRepository.deleteByTeacherId(teacherId);
    }
}
