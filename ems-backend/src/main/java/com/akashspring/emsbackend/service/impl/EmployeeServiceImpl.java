package com.akashspring.emsbackend.service.impl;

import com.akashspring.emsbackend.dto.EmployeeDto;
import com.akashspring.emsbackend.entity.Employee;
import com.akashspring.emsbackend.exception.ResourceNotFoundException;
import com.akashspring.emsbackend.mapper.EmployeeMapper;
import com.akashspring.emsbackend.repository.EmployeeRepository;
import com.akashspring.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmployee(EmployeeDto employeeDto) { // method is implemented from the Employee Service Interface
        Employee employee= EmployeeMapper.mapToEmployee(employeeDto);// mapping the client EmployeeDto to Employee Jpa
        Employee savedEmployee=employeeRepository.save(employee);// saved the Employee details into the table and storing that into a temp variable savedEmployee
        return EmployeeMapper.mapToEmployeeDto(savedEmployee); // mapping the savedEmployee of type Employee to EmployeeDto
    }

    @Override
    public EmployeeDto getEmployeeById(Long employeeId) {
       Employee employee= employeeRepository.findById(employeeId)
                .orElseThrow(() -> // lamda function of supplier functional interface to catch the exception
                        new ResourceNotFoundException("Employee doesn't exists with the given Id " +employeeId));
        return EmployeeMapper.mapToEmployeeDto(employee);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Employee> employees=employeeRepository.findAll();
        return employees.stream().map((employee)-> EmployeeMapper.mapToEmployeeDto(employee))
                .collect(Collectors.toList());

    }

    @Override
    public EmployeeDto updateEmployee(Long employeeId, EmployeeDto updatedEmployee) {
        Employee employee=employeeRepository.findById(employeeId).orElseThrow(
                ()-> new ResourceNotFoundException("Employee doesn't exists with the given Id " +employeeId)
        );
        employee.setFirstName(updatedEmployee.getFirstName());
        employee.setLastName(updatedEmployee.getLastName());
        employee.setEmail(updatedEmployee.getEmail());

        Employee updatedEmployeeOdj=employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(updatedEmployeeOdj);
    }

    @Override
    public void deleteEmployee(Long employeeId) {
        Employee employee=employeeRepository.findById(employeeId).orElseThrow(
                ()-> new ResourceNotFoundException("Employee doesn't exists with the given Id " +employeeId)
        );

        employeeRepository.delete(employee);
    }


}
