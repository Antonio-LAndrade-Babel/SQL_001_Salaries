package com.helloworld.salaries.company.salary.services.impl;

import com.helloworld.salaries.company.salary.services.EmployeeService;
import com.helloworld.salaries.exceptions.WrongParamsException;
import com.helloworld.salaries.mappers.EmployeeMapper;
import com.helloworld.salaries.mappers.SalaryMapper;
import com.helloworld.salaries.model.Employee;
import com.helloworld.salaries.model.Salary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeMapper employeeMapper;
    private final SalaryMapper salaryMapper;

    public EmployeeServiceImpl(EmployeeMapper employeeMapper, SalaryMapper salaryMapper) {
        this.employeeMapper = employeeMapper;
        this.salaryMapper = salaryMapper;
    }

    @Override
    public Employee findEmployeeByCode(String codEmpleado) throws WrongParamsException {
        return employeeMapper.findEmployeeByCode(codEmpleado);
    }

    @Override
    public List<Salary> getEmployeeSalariesByYear(String employeeCode, int year) throws WrongParamsException {
        return employeeMapper.getEmployeeSalariesByYear(employeeCode, year);
    }

    @Override
    public void insertSalaryForEmployeeAndYear(String codEmpleado, int year, double salaryValue) throws WrongParamsException {
        try {
            if (salaryMapper.countSalariesByEmployeeCodeAndYear(codEmpleado, year) == 0) {
                for (int month = 1; month <= 12; month++) {
                    salaryMapper.insertSalaryForEmployeeAndYear(codEmpleado, year, month, salaryValue);
                }
            }
        } catch (Exception e) {
            throw new WrongParamsException("");
        }
    }

    @Override
    public List<Employee> searchEmployees(String nombreEmpleado, String codEmpleado, int page, int size) throws WrongParamsException {
        int offset = (page - 1) * size;
        return employeeMapper.findEmployeeByName(nombreEmpleado, codEmpleado, size, offset);
    }

    @Override
    public Salary updateMonthlySalary(String employeeCode, double salary, int year, int month) throws WrongParamsException {
        if (salary < 0) throw new WrongParamsException("The salary shall not be negative");
        salaryMapper.updateMonthlySalary(employeeCode, salary, year, month);
        return salaryMapper.findSalaryEmployeeByCodeAndMonth(employeeCode, month, year);
    }
}
