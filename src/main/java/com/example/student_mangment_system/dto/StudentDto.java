package com.example.student_mangment_system.dto;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class StudentDto {

    @NotNull
    private Long studentId;

    @NotNull
    private String stname;

    @NotNull
    private String division;

}

