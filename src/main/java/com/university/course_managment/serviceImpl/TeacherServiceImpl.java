package com.university.course_managment.serviceImpl;

import com.university.course_managment.entities.Teacher;
import com.university.course_managment.repository.TeacherRepository;
import com.university.course_managment.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;


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
}
