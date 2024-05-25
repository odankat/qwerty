package com.qwerty.Employee.EmployeeController;

import com.qwerty.Employee.Service.Employee;
import com.qwerty.Employee.Service.EmployeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String add(@RequestParam("firstName") String firstName,
                      @RequestParam("lastName") String lastName,
                      @RequestParam("number") Integer number
    ) {
        Employee employee = new Employee(firstName, lastName);
        employeeService.addEmployee(number, employee);
        return employee.toString();
    }

    @GetMapping("/remove")
    public String remove(@RequestParam("number") Integer number) {
        employeeService.removeEmployee(number);
        return number.toString();
    }

    @GetMapping("/find")
    public String find(@RequestParam("firstName") String firstName,
                       @RequestParam("lastName") String lastName) {
        Employee employee = new Employee(firstName, lastName);
        employeeService.findEmployee(employee);
        return employee.toString();
    }

    @GetMapping()
    public void findAll() {
        employeeService.findAll();
    }
}
