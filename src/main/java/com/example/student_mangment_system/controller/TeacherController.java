package com.example.student_mangment_system.controller;

import com.example.student_mangment_system.dto.TeacherDto;
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
    public ResponseEntity<List<TeacherDto>> getTeachers(){
        List<TeacherDto> teacherList= teacherService.getTeachers();
        return  new ResponseEntity<List<TeacherDto>>(teacherList, HttpStatus.OK);
    }

    @PostMapping("/teacher")
    public ResponseEntity<TeacherDto> addTeacher(@RequestBody TeacherDto teacher){
        TeacherDto teacherDto= teacherService.addTeacher(teacher);
        return new ResponseEntity<TeacherDto>(teacherDto, HttpStatus.CREATED);
    }

    @PutMapping("/teacher")
    public ResponseEntity<TeacherDto> updateTeacher(@RequestBody TeacherDto teacherDto){
        TeacherDto update_teacher = teacherService.updateTeacher(teacherDto);
        return new ResponseEntity<TeacherDto>(update_teacher, HttpStatus.CREATED);
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

