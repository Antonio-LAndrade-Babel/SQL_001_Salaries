package com.helloworld.salaries.company.salary.services;

import com.helloworld.salaries.exceptions.WrongParamsException;
import com.helloworld.salaries.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee findEmployeeByCode(String codEmpleado) throws WrongParamsException;
    List<Double> getEmployeeSalariesByYear(String employeeCode, int year) throws WrongParamsException;
    void insertSalaryForEmployeeAndYear(String codEmpleado, int year, double salaryValue) throws WrongParamsException;
    List<Employee> searchEmployees(String name, String codEmpleado, int page, int size) throws WrongParamsException;
    void updateMonthlySalary(String employeeCode, double salary, int year, int month) throws WrongParamsException;
}