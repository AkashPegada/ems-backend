package com.akashspring.emsbackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {

    @Id // from jakarta.persistence jpa package for marking a primary key in table
    @GeneratedValue(strategy = GenerationType.IDENTITY) // strategy uses database auto increment feature for primary key id in the table
    private Long id;

    @Column(name = "first_name") // maps the column name in the table as first_name
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_id", nullable = false, unique = true) // nullable and unique makes sure the value can't be empty and should be unique for any entry
    private String email;

}
