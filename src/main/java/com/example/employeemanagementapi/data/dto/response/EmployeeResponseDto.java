package com.example.employeemanagementapi.data.dto.response;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class EmployeeResponseDto {
    private String name;
    private String surname;
    private int age;
    private BigDecimal salary;
}
