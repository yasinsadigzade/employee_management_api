package com.example.employeemanagementapi.data.repository;

import com.example.employeemanagementapi.data.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
