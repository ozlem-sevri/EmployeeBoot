package com.example.employeeboot.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Document(collection = "Employee")
@Getter
@Builder(toBuilder = true)
public class Employee {
    @Id
    private int id;

    @NotEmpty(message = "Name cannot be empty or null")
    private String name;

    @NotEmpty(message = "Surname cannot be empty or null")
    private String surname;

    @NotEmpty(message = "Email cannot be empty or null")
    @Email(message = "Email should be valid")
    @Indexed(unique = true)
    private String email;

    private Gender gender;

    @Valid
    private Address address;

    @NotNull(message = "Department cannot be null")
    private Department department;

    @Min(value = 1000, message = "Salary should be at least 1000")
    private int salary;

}
