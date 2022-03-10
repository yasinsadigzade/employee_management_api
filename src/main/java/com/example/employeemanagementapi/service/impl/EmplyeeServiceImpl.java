package com.example.employeemanagementapi.service.impl;

import com.example.employeemanagementapi.config.ApplicationConfiguration;
import com.example.employeemanagementapi.data.dto.request.EmployeeRequestDto;
import com.example.employeemanagementapi.data.dto.response.EmployeeResponseDto;
import com.example.employeemanagementapi.data.entity.Employee;
import com.example.employeemanagementapi.data.repository.EmployeeRepository;
import com.example.employeemanagementapi.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EmplyeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ApplicationConfiguration applicationConfiguration;

    @Override
    public List<EmployeeResponseDto> findEmployees() {

        List<Employee> employeeList = employeeRepository.findAll();

//        List<EmployeeResponseDto> collect = employeeList.stream().map(user -> applicationConfiguration.getModelMapper().map(user, EmployeeResponseDto.class)).collect(Collectors.toList());

        List<EmployeeResponseDto> returnValue = new ArrayList<>();
        employeeList.forEach((user) -> {
            EmployeeResponseDto employeeResponseDto = applicationConfiguration.getModelMapper().map(user, EmployeeResponseDto.class);
            returnValue.add(employeeResponseDto);
        });
        return returnValue;
    }

    @Override
    public void saveEmployee(EmployeeRequestDto employeeRequestDto) {
        employeeRepository.save(dtoToEntity(employeeRequestDto));
    }

    private Employee dtoToEntity(EmployeeRequestDto employeeRequestDto) {
        Employee map = applicationConfiguration.getModelMapper().map(employeeRequestDto, Employee.class);
        return map;
    }
}
