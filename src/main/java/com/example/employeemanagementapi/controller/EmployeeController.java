package com.example.employeemanagementapi.controller;

import com.example.employeemanagementapi.data.dto.request.EmployeeRequestDto;
import com.example.employeemanagementapi.data.dto.response.EmployeeResponseDto;
import com.example.employeemanagementapi.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/employees")
    public List<EmployeeResponseDto> getEmployees() {
        return employeeService.findEmployees();
    }

    @PostMapping("/")
    public void saveEmployee(@RequestBody EmployeeRequestDto employeeRequestDto){
        employeeService.saveEmployee(employeeRequestDto);
    }

}
