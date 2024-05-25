package com.qwerty.Employee.Service;

import com.qwerty.Employee.Exception.EmployeeAlreadyAddedException;
import com.qwerty.Employee.Exception.EmployeeNotFoundException;
import com.qwerty.Employee.Exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service

public class EmployeeService {
    public final Map<Integer,Employee> employees;
    public EmployeeService() {
        this.employees = new HashMap<>();
    }
    final int maxEmployees = 10;

    public String addEmployee(Integer number, Employee employee) {
        if (employees.containsKey(number)){
            throw new EmployeeAlreadyAddedException("такой сотрудник есть");
        }
        if (employees.size() > maxEmployees) {
            throw new EmployeeStorageIsFullException("превышен лимит количества сотрудников в фирме");
        }
        employees.put(number,employee);
        return employee.toString();
    }

    public Employee removeEmployee(Integer number) {
        if(employees.containsKey(number)) {
            employees.remove(number);
            return employees.get(number);
        }
        throw new EmployeeNotFoundException("Сотрудника нет");
    }

    public String findEmployee(Employee employee) {
        if(employees.containsKey(employee)) {
            return employee.toString();
        }
        throw new EmployeeNotFoundException("Сотрудника нет");


    }

    public String findAll() {
        return employees.toString();
    }


}
