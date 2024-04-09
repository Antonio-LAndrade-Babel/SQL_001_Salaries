package com.helloworld.salaries.model;

import lombok.Data;

@Data
public class Salary {
    private Integer id;
    private String codEmpleado;
    private Double costeHora;
    private String nombreEmpleado;
    private Double salary;
    private Integer salaryMonth;
    private Integer salaryYear;
}
