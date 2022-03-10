package com.example.employeemanagementapi.service;

import com.example.employeemanagementapi.data.dto.request.EmployeeRequestDto;
import com.example.employeemanagementapi.data.dto.response.EmployeeResponseDto;

import java.util.List;

public interface EmployeeService {
    List<EmployeeResponseDto> findEmployees();

    void saveEmployee(EmployeeRequestDto employeeRequestDto);
}
