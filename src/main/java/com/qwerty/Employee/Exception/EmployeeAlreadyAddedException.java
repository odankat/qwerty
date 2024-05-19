package com.qwerty.Employee.Exception;

public class EmployeeAlreadyAddedException extends RuntimeException{
    public EmployeeAlreadyAddedException(String massage){
        super(massage);
    }
}
