package com.scbcompany.cruddemo.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeExceptionResponse {
    private int statusCode;
    private String message;
    private long timeStamp;
}
