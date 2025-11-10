package com.akashspring.emsbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto { // for mapping the data from client to server entity

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}
