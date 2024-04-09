package com.helloworld.salaries.company.salary.services;

import com.helloworld.salaries.exceptions.WrongParamsException;
import com.helloworld.salaries.model.Salary;

import java.util.List;

public interface SalaryService {
    double findAverageSalaryByYear(int year) throws WrongParamsException;
    List<Double> findSalariesByEmployeeCodeAndYear(String codEmpleado, int year) throws WrongParamsException;
    void insertSalaryForEmployeeAndYear(String codEmpleado, int year, double salaryValue) throws WrongParamsException;
    void updateMonthlySalary(String codEmpleado, double salary, int year, int month) throws WrongParamsException;
}
