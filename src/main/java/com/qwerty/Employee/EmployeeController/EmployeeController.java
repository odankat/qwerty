package com.qwerty.Employee.EmployeeController;

import com.qwerty.Employee.Service.Employee;
import com.qwerty.Employee.Service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping("/employee")
    public String employee() {
        return "Hello";
    }
    @GetMapping("/add")
    public String add(@RequestParam("firstName") String firstName,
                      @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
       employeeService.addEmployee(employee);
        return employee.toString();
    }
    @GetMapping("/remove")
    public String remove(@RequestParam("firstName") String firstName,
                         @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employeeService.removeEmployee(employee);
        return "[eq";

    }
    @GetMapping("/find")
    public String find(@RequestParam("firstName") String firstName,
                         @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employeeService.searchEmployee(employee);
        return "";
    }
}
