package com.example.student_mangment_system.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteCourseDto {

    private Long courseId;
    private Long studentId;
    private Long teacherId;
}
