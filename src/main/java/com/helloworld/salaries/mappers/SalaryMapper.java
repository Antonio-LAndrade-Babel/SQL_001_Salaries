package com.helloworld.salaries.mappers;

import com.helloworld.salaries.model.Employee;
import com.helloworld.salaries.model.Salary;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SalaryMapper {
    @Select("SELECT AVG(SALARY) FROM salary WHERE SALARYYEAR = #{year}")
    double findAverageSalaryByYear(int year);

    @Select("SELECT * FROM salary WHERE CODEMPLEADO = #{codEmpleado} AND SALARYYEAR = #{year}")
    List<Double> findSalariesByEmployeeCodeAndYear(@Param("codEmpleado") String codEmpleado, @Param("year") int year);

    @Insert("INSERT INTO salary (CODEMPLEADO, COSTEHORA, NOMBREEMPLEADO, SALARY, SALARYMONTH, SALARYYEAR) VALUES (#{codEmpleado}, #{costeHora}, #{nombreEmpleado}, #{salary}, #{salaryMonth}, #{salaryYear})")
    void insertSalary(Salary salary);

    @Select("SELECT COUNT(*) FROM salary WHERE CODEMPLEADO = #{codEmpleado} AND SALARYYEAR = #{year}")
    int countSalariesByEmployeeCodeAndYear(@Param("codEmpleado") String codEmpleado, @Param("year") int year);

    @Insert("INSERT INTO salary (CODEMPLEADO, SALARYYEAR, SALARYMONTH, SALARY) VALUES (#{codEmpleado}, #{year}, #{month}, #{salary})")
    void insertSalaryForEmployeeAndYear(@Param("codEmpleado") String codEmpleado, @Param("year") int year, @Param("month") int month, @Param("salary") double salary);

    @Update("UPDATE salary SET SALARY = #{salary} WHERE CODEMPLEADO = #{codEmpleado} AND SALARYYEAR = #{year} AND SALARYMONTH = #{month}")
    void updateMonthlySalary(@Param("codEmpleado") String codEmpleado, @Param("salary") double salary, @Param("year") int year, @Param("month") int month);

    @Select("SELECT * FROM salary WHERE CODEMPLEADO = #{codEmpleado} AND SALARYYEAR = #{year} AND SALARYMONTH = #{month}")
    Salary findSalaryEmployeeByCodeAndMonth(@Param("codEmpleado") String codEmpleado, @Param("month") int month, @Param("year") int year);
}
