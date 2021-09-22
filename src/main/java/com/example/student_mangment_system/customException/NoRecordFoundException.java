package com.example.student_mangment_system.customException;

public class NoRecordFoundException extends RuntimeException{

    private String message;

    public NoRecordFoundException(){};

    public NoRecordFoundException(String message){
        this.message = message;
    };

}
