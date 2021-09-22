package com.example.student_mangment_system.customException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NoRecordFoundException extends RuntimeException{

    private static final long serialVersionUID = 159874652L;

    public NoRecordFoundException(String message){
        super(message);
    };

}
