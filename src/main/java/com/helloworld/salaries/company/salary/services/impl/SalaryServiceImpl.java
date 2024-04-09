package com.helloworld.salaries.company.salary.services.impl;

import com.helloworld.salaries.company.salary.services.SalaryService;
import com.helloworld.salaries.exceptions.WrongParamsException;
import com.helloworld.salaries.mappers.SalaryMapper;
import com.helloworld.salaries.model.Salary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalaryServiceImpl implements SalaryService {
    private final SalaryMapper salaryMapper;

    public SalaryServiceImpl(SalaryMapper salaryMapper) {
        this.salaryMapper = salaryMapper;
    }

    @Override
    public double findAverageSalaryByYear(int year) throws WrongParamsException {
        return salaryMapper.findAverageSalaryByYear(year);
    }

    @Override
    public List<Double> findSalariesByEmployeeCodeAndYear(String codEmpleado, int year) throws WrongParamsException {
        return salaryMapper.findSalariesByEmployeeCodeAndYear(codEmpleado, year);
    }

    @Override
    public void insertSalaryForEmployeeAndYear(String codEmpleado, int year, double salaryValue) throws WrongParamsException {
        if (salaryMapper.countSalariesByEmployeeCodeAndYear(codEmpleado, year) == 0) {
            for (int month = 1; month <= 12; month++) {
                Salary salary = new Salary();
                salary.setCodEmpleado(codEmpleado);
                salary.setSalaryYear(year);
                salary.setSalaryMonth(month);
                salary.setSalary(salaryValue);
                salaryMapper.insertSalary(salary);
            }
        }
    }

    @Override
    public void updateMonthlySalary(String codEmpleado, double salary, int year, int month) throws WrongParamsException {
        salaryMapper.updateMonthlySalary(codEmpleado, salary, year, month);
    }
}
