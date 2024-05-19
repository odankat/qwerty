package com.qwerty.Employee.Service;

import com.qwerty.Employee.Exception.EmployeeAlreadyAddedException;
import com.qwerty.Employee.Exception.EmployeeNotFoundException;
import com.qwerty.Employee.Exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class EmployeeService {
    private final List<Employee> employees;
    public EmployeeService() {
        this.employees = new ArrayList<>();
    }
    final int maxEmployees = 10;

    public String addEmployee(Employee employee) {
        if (employees.contains(employee)){
            throw new EmployeeAlreadyAddedException("такой сотрудник есть");
        }
        if (employees.size() > maxEmployees) {
            throw new EmployeeStorageIsFullException("превышен лимит количества сотрудников в фирме");
        }
        employees.add(employee);
        return employee.toString();
    }

    public String removeEmployee(Employee employee) {
        if(employees.contains(employee)) {
            employees.remove(employee);
            return employee.toString();
        }
        throw new EmployeeNotFoundException("Сотрудника нет");
    }

    public String findEmployee(Employee employee) {
        if(employees.contains(employee)) {
            return employee.toString();
        }
        throw new EmployeeNotFoundException("Сотрудника нет");


    }

    public List<Employee> findAll() {
        return new ArrayList<>(employees);
    }

}
