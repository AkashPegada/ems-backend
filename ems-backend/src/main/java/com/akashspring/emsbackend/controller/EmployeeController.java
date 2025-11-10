package com.akashspring.emsbackend.controller;

import com.akashspring.emsbackend.dto.EmployeeDto;
import com.akashspring.emsbackend.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    //Build Add Employee REST API
    @PostMapping // used to map the POST request to the method
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){ // @RequestBody extracts the Jason values and convert them to java objects
        EmployeeDto savedEmployee= employeeService.createEmployee(employeeDto); // method inherited from EmployeeService Interface and assigned to a EmployeeDto object
        return new ResponseEntity<>(savedEmployee,HttpStatus.CREATED);
    }

    //Build GET Employee REST API
    @GetMapping ("{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable("id") Long employeeId){
        EmployeeDto employeeDto= employeeService.getEmployeeById(employeeId);
        return ResponseEntity.ok(employeeDto);
    }

    //Build Get All Employees REST API
    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmployees(){
        List<EmployeeDto> employees= employeeService.getAllEmployees();
        return ResponseEntity.ok(employees);
    }

    //Build Update Employee REST API
    @PutMapping ("{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long employeeId, @RequestBody EmployeeDto updateEmployee){
        EmployeeDto employeeDto=employeeService.updateEmployee(employeeId, updateEmployee);
        return ResponseEntity.ok(employeeDto);
    }

    //Build Delete Employee REST API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long employeeId){
       employeeService.deleteEmployee(employeeId);
       return ResponseEntity.ok("Employee got deleted successfully!");
    }
}
