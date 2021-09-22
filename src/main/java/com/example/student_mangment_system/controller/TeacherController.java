package com.example.student_mangment_system.controller;

import com.example.student_mangment_system.entities.Teacher;
import com.example.student_mangment_system.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;

    @GetMapping("/teacher")
    public ResponseEntity<List<Teacher>> getTeachers(){
        List<Teacher> teacherList= teacherService.getTeachers();
        return  new ResponseEntity<List<Teacher>>(teacherList, HttpStatus.OK);
    }

    @PostMapping("/teacher")
    public ResponseEntity<Teacher> addTeacher(@RequestBody Teacher teacher){
        Teacher teacher1= teacherService.addTeacher(teacher);
        return new ResponseEntity<Teacher>(teacher1, HttpStatus.CREATED);
    }

    @PutMapping("/teacher")
    public ResponseEntity<Teacher> updateTeacher(@RequestBody Teacher teacher){
        Teacher update_teacher = teacherService.updateTeacher(teacher);
        return new ResponseEntity<Teacher>(update_teacher, HttpStatus.CREATED);
    }

    @DeleteMapping("/teacher/{teacherId}")
    public ResponseEntity<?> deleteTeacher(@PathVariable("teacherId") Long teacherId){
        teacherService.deleteTeacher(teacherId);
        return ResponseEntity.ok("Teacher with teacherId= " + teacherId + " deleted from all tables Successfully");
    }

    @DeleteMapping("/deleteTeacherfromJoinTable/{teacherId}")
    public ResponseEntity<?> deleteTeacherfromJoinTable(@PathVariable("teacherId") Long teacherId){
        teacherService.deleteTeacherfromJoinTable(teacherId);
        return ResponseEntity.ok("Teacher with teacherId= " + teacherId + " deleted from join table Successfully");
    }
}

