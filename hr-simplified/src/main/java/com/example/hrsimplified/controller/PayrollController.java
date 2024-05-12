package com.example.hrsimplified.controller;

import com.example.hrsimplified.domain.Payroll;
import com.example.hrsimplified.dto.PayrollDTO;
import com.example.hrsimplified.service.PayrollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("payroll")
public class PayrollController {

    @Autowired
    private PayrollService payrollService;

    @GetMapping("")
    public ResponseEntity<List<Payroll>> getAll(){
        return new ResponseEntity<>(payrollService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Payroll> getById(@PathVariable String id) throws Exception{
        return new ResponseEntity<>(payrollService.findById(id), HttpStatus.OK);
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<List<Payroll>> getByEmployeeId(@PathVariable String id) {
        return new ResponseEntity<>(payrollService.findByEmployeeId(id), HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<Payroll> create(@RequestBody PayrollDTO payroll) throws Exception {
        return new ResponseEntity<>(payrollService.create(payroll), HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Payroll> update(@RequestBody PayrollDTO payroll, @PathVariable String id) throws Exception {
        return new ResponseEntity<>(payrollService.update(payroll, id), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteById(@PathVariable String id) {
        payrollService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
