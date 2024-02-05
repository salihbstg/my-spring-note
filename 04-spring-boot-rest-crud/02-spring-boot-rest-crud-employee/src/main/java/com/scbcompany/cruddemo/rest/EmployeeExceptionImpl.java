package com.scbcompany.cruddemo.rest;

public class EmployeeExceptionImpl extends RuntimeException{
    public EmployeeExceptionImpl(String message) {
        super(message);
    }

    public EmployeeExceptionImpl(String message, Throwable cause) {
        super(message, cause);
    }

    public EmployeeExceptionImpl(Throwable cause) {
        super(cause);
    }
}
