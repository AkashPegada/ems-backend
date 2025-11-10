package com.akashspring.emsbackend.mapper;

import com.akashspring.emsbackend.dto.EmployeeDto;
import com.akashspring.emsbackend.entity.Employee;

public class EmployeeMapper {// Mapping logic between the EmployeeDto and Employee Jpa entity

    public static EmployeeDto mapToEmployeeDto(Employee employee){ // to map the values of Employee entity Jpa to EmployeeDto
        return new EmployeeDto(
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail()
        );
    }

    public static Employee mapToEmployee(EmployeeDto employeeDto){ // to map the values of EmployeeDto to Employee entity jpa
        return new Employee(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }
}
