package com.example.hrsimplified.controller;

import com.example.hrsimplified.domain.Employee;
import com.example.hrsimplified.dto.EmployeeDTO;
import com.example.hrsimplified.dto.FilterDTO;
import com.example.hrsimplified.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAll() {
        return new ResponseEntity<>(employeeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> getById(@PathVariable String id) throws Exception {
        return new ResponseEntity<>(employeeService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<Employee> getByEmail(@PathVariable String email) {
        return new ResponseEntity<>(employeeService.findByEmail(email), HttpStatus.OK);
    }

    @PostMapping("/filter")
    public ResponseEntity<List<Employee>> filter(@RequestBody FilterDTO filter) {
        return new ResponseEntity<>(employeeService.filter(filter), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Employee> create(@RequestBody EmployeeDTO employee) {
        return new ResponseEntity<>(employeeService.create(employee), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Employee> update(@RequestBody EmployeeDTO employee, @PathVariable String id) throws Exception {
        return new ResponseEntity<>(employeeService.update(employee, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> delete(@PathVariable String id) {
        employeeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
