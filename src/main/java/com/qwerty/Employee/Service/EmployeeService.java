package com.qwerty.Employee.Service;

import com.qwerty.Employee.Exception.EmployeeAlreadyAddedException;
import com.qwerty.Employee.Exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service

public class EmployeeService {
    List<Employee> employees = new ArrayList<>(List.of());
    final int maxEmployees = 10;

    public void addEmployee(Employee employee) {
        employees.add(employee);
        if (employees.size() > maxEmployees) {
            throw new EmployeeStorageIsFullException("превышен лимит количества сотрудников в фирме");
        }
    }

    public void removeEmployee(Employee employee) {
        for (int i = 0; i < employees.size() || employee.hashCode() == employees.get(i).hashCode(); i++) {
            employees.remove(i);
        }
    }

    public void searchEmployee(Employee employee) {
        int i = 0;
        if (employees.get(i) != employee) {
            for (; i < employees.size(); i++) ;
        } else {
            throw new EmployeeAlreadyAddedException("сотрудник не найден");
        }

    }
}
