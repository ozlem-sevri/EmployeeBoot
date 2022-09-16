package com.example.employeeboot.service;

import com.example.employeeboot.model.Employee;
import com.example.employeeboot.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public Employee addEmployee(Employee employee) {
        if (employeeRepository.findByEmail(employee.getEmail()).isEmpty())
            return employeeRepository.save(employee);
        return null;

    }

    public Employee getEmployee(int id) {
        if (employeeRepository.findById(id).isPresent())
            return employeeRepository.findById(id).get();
        return null;
    }

    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    public Employee updateEmployee(Employee employee) {
        if (employeeRepository.findById(employee.getId()).isEmpty())
            return null;

        return employeeRepository.save(employeeRepository.findById(employee.getId()).get().toBuilder()
                                        .name(employee.getName())
                                        .surname(employee.getSurname())
                                        .email(employee.getEmail())
                                        .gender(employee.getGender())
                                        .address(employee.getAddress())
                                        .department(employee.getDepartment())
                                        .salary(employee.getSalary())
                                        .build());

    }

    public boolean deleteEmployee(int id) {

        if (employeeRepository.findById(id).isEmpty())
            return false ;
        employeeRepository.deleteById(id);
       return true;
    }
}
