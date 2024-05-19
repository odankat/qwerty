package com.qwerty.Employee.Exception;

public class EmployeeStorageIsFullException extends RuntimeException{
    public EmployeeStorageIsFullException(String massage){
        super(massage);
    }
}
