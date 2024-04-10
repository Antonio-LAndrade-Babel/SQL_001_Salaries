package com.helloworld.salaries.mappers;

import com.helloworld.salaries.model.Employee;
import com.helloworld.salaries.model.Salary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    @Select("SELECT * FROM employee WHERE CODEMPLEADO = #{codEmpleado}")
    Employee findEmployeeByCode(@Param("codEmpleado") String codEmpleado);
    @Select("SELECT * FROM employee WHERE NOMBREEMPLEADO LIKE CONCAT('%', #{name}, '%') AND CODEMPLEADO LIKE CONCAT('%', #{codEmpleado}, '%') LIMIT #{limit} OFFSET #{offset}")
    List<Employee> findEmployeeByName(@Param("name") String name, @Param("codEmpleado") String codEmpleado, @Param("limit") int limit, @Param("offset") int offset);
    @Select("SELECT * FROM salary WHERE CODEMPLEADO = #{employeeCode} AND SALARYYEAR = #{year}")
    List<Salary> getEmployeeSalariesByYear(@Param("employeeCode") String employeeCode, @Param("year") int year);
}