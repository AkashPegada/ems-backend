package com.akashspring.emsbackend.repository;

import com.akashspring.emsbackend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

// creating interface to perform crud operations on the JpaRepository
public interface EmployeeRepository extends JpaRepository<Employee, Long> { // Genric interface with two parameters entity type and primary key type of the extended interface
//jpaRepository internally have SimpleJpaRepository class implementation where it's annotated with @Repository and @Transactional
// so there is no need to explicitly use @Repository for repo interface and can use all the methods and crud operation directly as it's annotated with @Transactional


}
