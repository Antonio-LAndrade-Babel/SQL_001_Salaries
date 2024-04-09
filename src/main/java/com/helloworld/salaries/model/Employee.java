package com.helloworld.salaries.model;

import lombok.Data;

import java.util.Date;

@Data
public class Employee {
    private String codEmpleado;
    private String nombreEmpleado;
    private Date fechaInicio;
    private Date fechaBaja;
    private Integer office;
}
