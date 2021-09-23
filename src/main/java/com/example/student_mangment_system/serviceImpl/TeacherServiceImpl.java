package com.example.student_mangment_system.serviceImpl;

import com.example.student_mangment_system.customException.BadRequestException;
import com.example.student_mangment_system.customException.NoRecordFoundException;
import com.example.student_mangment_system.dto.TeacherDto;
import com.example.student_mangment_system.entities.Teacher;
import com.example.student_mangment_system.repository.StudentEnrollmentRepository;
import com.example.student_mangment_system.repository.TeacherRepository;
import com.example.student_mangment_system.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeacherServiceImpl implements TeacherService {

    private final TeacherRepository teacherRepository;

    private final StudentEnrollmentRepository studentEnrollmentRepository;

    @Override
    public List<TeacherDto> getTeachers() {
        List<TeacherDto> teacherDtoList= teacherRepository.findAll().stream().map(teacher ->{
            TeacherDto teacherDto = new TeacherDto();
            teacherDto.setTeacherId(teacher.getTeacherId());
            teacherDto.setName(teacher.getName());
            return teacherDto;
        }).collect(Collectors.toList());
        if(teacherDtoList.isEmpty()){
            throw new NoRecordFoundException("Teacher list is empty");
        }
        else {
            return teacherDtoList;
        }
    }

    @Override
    public TeacherDto addTeacher(TeacherDto teacherDto) {
        Teacher teacher;
        if(teacherDto.getName().isEmpty() || teacherDto.getName().isBlank()){
            throw new BadRequestException("Please enter teacher name.");
        }
        else{
            teacher = new Teacher();
            teacher.setTeacherId(teacherDto.getTeacherId());
            teacher.setName(teacherDto.getName());
            teacherRepository.save(teacher);
            return null;
        }
    }

    @Override
    public TeacherDto updateTeacher(TeacherDto teacherDto) {
        Teacher teacher;
        if(teacherDto.getName().isEmpty() || teacherDto.getName().isBlank()){
            throw new BadRequestException("Please enter teacher name.");
        }
        else{
            teacher = new Teacher();
            teacher.setTeacherId(teacherDto.getTeacherId());
            teacher.setName(teacherDto.getName());
            teacherRepository.save(teacher);
            return null;
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
