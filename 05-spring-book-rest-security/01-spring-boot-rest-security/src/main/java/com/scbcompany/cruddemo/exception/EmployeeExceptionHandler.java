package com.scbcompany.cruddemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<EmployeeExceptionResponse> employeeExceptionImpl(EmployeeExceptionImpl employeeException){
        EmployeeExceptionResponse error=new EmployeeExceptionResponse();
        error.setMessage(employeeException.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        error.setStatusCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}
