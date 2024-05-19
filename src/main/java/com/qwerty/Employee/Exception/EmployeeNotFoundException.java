package com.qwerty.Employee.Exception;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String massage){
        super(massage);
    }
}
