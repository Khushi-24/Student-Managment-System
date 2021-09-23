package com.example.student_mangment_system.service;

import com.example.student_mangment_system.dto.TeacherDto;
import com.example.student_mangment_system.entities.Teacher;

import java.util.List;

public interface TeacherService {

    public List<TeacherDto> getTeachers();

    public TeacherDto addTeacher(TeacherDto teacherDto);

    public TeacherDto updateTeacher(TeacherDto teacherDto);

    public Teacher deleteTeacher(Long teacherId);

    void deleteTeacherfromJoinTable(Long teacherId);
}
