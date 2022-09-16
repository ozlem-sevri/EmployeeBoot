package com.example.employeeboot.model;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;


@Getter
@Setter
public class Address {
    @NotEmpty(message = "Country cannot be null or empty")
    private String country;
    @NotEmpty(message = "City cannot be empty or null")
    private String city;

}
