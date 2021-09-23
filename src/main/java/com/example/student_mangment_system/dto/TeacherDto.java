package com.example.student_mangment_system.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class TeacherDto {

    @NotNull
    private Long teacherId;

    @NotNull
    private String name;
}
