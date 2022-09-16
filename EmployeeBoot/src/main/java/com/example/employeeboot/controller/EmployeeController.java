package com.example.employeeboot.controller;

import com.example.employeeboot.model.Employee;
import com.example.employeeboot.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> addEmployee(@Valid @RequestBody Employee employee) {
        if (Objects.nonNull(employeeService.addEmployee(employee)) )
            return new ResponseEntity<>(employee, HttpStatus.CREATED);

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int id) {
        Employee employee = employeeService.getEmployee(id);
        if (Objects.nonNull(employee))
            return new ResponseEntity<>(employee, HttpStatus.OK);

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee() {
        List<Employee> employeeList = employeeService.getAllEmployee();
        if (Objects.isNull(employeeList) || employeeList.isEmpty() )
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(employeeList, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Employee> updateEmployee(@Valid @RequestBody Employee employee) {
        Employee employee1 = employeeService.updateEmployee(employee);
        if (Objects.nonNull(employee1))
            return new ResponseEntity<>(employee1, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Employee> deleteEmployee(@PathVariable int id) {

        if ( employeeService.deleteEmployee(id))
            return new ResponseEntity<>( HttpStatus.NO_CONTENT);
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }

}
