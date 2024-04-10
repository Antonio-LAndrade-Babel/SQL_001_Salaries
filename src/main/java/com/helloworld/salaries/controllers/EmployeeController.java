package com.helloworld.salaries.controllers;

import com.helloworld.salaries.company.salary.services.EmployeeService;
import com.helloworld.salaries.exceptions.WrongParamsException;
import com.helloworld.salaries.model.Employee;
import com.helloworld.salaries.model.Salary;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeCode}/salary/{year}")
    public ResponseEntity<List<Salary>> getEmployeeSalariesByYear(@PathVariable String employeeCode, @PathVariable int year) {
        try {
            List<Salary> salaries = employeeService.getEmployeeSalariesByYear(employeeCode, year);
            return ResponseEntity.ok().body(salaries);
        } catch (WrongParamsException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PostMapping("/{employeeCode}/salary/{year}")
    public ResponseEntity<?> insertSalariesForEmployeeYear(@PathVariable String employeeCode,
                                                           @PathVariable int year,
                                                           @RequestBody Double salaryValue) {
        try {
            employeeService.insertSalaryForEmployeeAndYear(employeeCode, year, salaryValue);
            return ResponseEntity.ok("Salaries created for employee " + employeeCode + " in year " + year);
        } catch (WrongParamsException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }


    @GetMapping
    public ResponseEntity<List<Employee>> searchEmployees(
            @RequestParam(value = "name", required = false) String name,
            @RequestParam(value = "codEmployee", required = false) String codEmployee,
            @RequestParam(value = "page", defaultValue = "1") int page) {
        try {
            List<Employee> employees = employeeService.searchEmployees(name, codEmployee, page, 10);
            return ResponseEntity.ok().body(employees);
        } catch (WrongParamsException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @PutMapping("/{employeeCode}/salary/{year}/month/{month}")
    public ResponseEntity<?> updateMonthlySalary(@PathVariable String employeeCode,
                                                 @PathVariable int year,
                                                 @PathVariable int month,
                                                 @RequestBody Double salary) {
        try {
            return ResponseEntity.ok(employeeService.updateMonthlySalary(employeeCode, salary, year, month));
        } catch (WrongParamsException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
