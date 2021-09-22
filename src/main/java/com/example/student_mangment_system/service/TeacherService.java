package com.example.student_mangment_system.service;

import com.example.student_mangment_system.entities.Teacher;

import java.util.List;

public interface TeacherService {

    public List<Teacher> getTeachers();

    public Teacher addTeacher(Teacher teacher);

    public Teacher updateTeacher(Teacher teacher);

    public Teacher deleteTeacher(Long teacherId);

    void deleteTeacherfromJoinTable(Long teacherId);
}
