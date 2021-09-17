package com.university.course_managment.service;

import com.university.course_managment.entities.Teacher;

import java.util.List;

public interface TeacherService {
    public List<Teacher> getTeachers();

    public Teacher addTeacher(Teacher teacher);

    public Teacher getOneteacher(Long teacherId);
}
