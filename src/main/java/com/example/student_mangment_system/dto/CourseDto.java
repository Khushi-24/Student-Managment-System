package com.example.student_mangment_system.dto;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@RequiredArgsConstructor
public class CourseDto {

    @NotNull(message = "CourseId can't be null")
    private Long courseId;

    @NotNull
    @NotBlank
    private String coursename;

    @NotNull
    private String description;
}
