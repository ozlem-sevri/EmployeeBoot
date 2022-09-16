package com.example.employeeboot.repository;

import com.example.employeeboot.model.Employee;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface EmployeeRepository extends MongoRepository<Employee, Integer> {
    Optional<Employee> findByEmail(String email);

}
