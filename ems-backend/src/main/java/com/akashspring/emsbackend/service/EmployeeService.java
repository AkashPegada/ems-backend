package com.akashspring.emsbackend.service;

import com.akashspring.emsbackend.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {
    EmployeeDto createEmployee(EmployeeDto employeeDto);//creating employee and inserting the employee as new entry in DB table
    EmployeeDto getEmployeeById(Long employeeId);// retrieving the employee details through id from GET POST API request
    List<EmployeeDto> getAllEmployees();
    EmployeeDto updateEmployee (Long employeeId, EmployeeDto updatedEmployee);
    void deleteEmployee(Long employeeId);
}
