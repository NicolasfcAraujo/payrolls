package com.example.hrsimplified.service;

import com.example.hrsimplified.domain.Employee;
import com.example.hrsimplified.domain.Payroll;
import com.example.hrsimplified.dto.PayrollDTO;
import com.example.hrsimplified.repository.PayrollRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PayrollService {

    @Autowired
    private PayrollRepository payrollRepository;

    @Autowired
    private EmployeeService employeeService;

    public List<Payroll> findAll(){
        return payrollRepository.findAll();
    }

    public Payroll findById(String id) throws Exception{
        Optional<Payroll> payroll = payrollRepository.findById(Long.valueOf(id));

        if (payroll.isEmpty()) {
            throw new Exception(String.format("Payroll with ID %s not found", id));
        }

        return payroll.get();
    }

    public List<Payroll> findByEmployeeId(String id) {
        return payrollRepository.findByEmployeeId(Long.valueOf(id));
    }

    public Payroll save(Payroll payroll) {
        return payrollRepository.save(payroll);
    }

    public Payroll create(PayrollDTO payrollDTO) throws Exception {
        Payroll payroll = new Payroll(
                payrollDTO.salary(),
                payrollDTO.bonus(),
                payrollDTO.taxes(),
                payrollDTO.paymentDate()
        );
        Employee employee = employeeService.findById(String.valueOf(payrollDTO.employeeId()));

        payroll.setEmployee(employee);

        System.out.println(payrollDTO);

        return this.save(payroll);
    }

    public Payroll update(PayrollDTO payrollDTO, String id) throws Exception {
        Payroll payroll = new Payroll(
                payrollDTO.salary(),
                payrollDTO.bonus(),
                payrollDTO.taxes(),
                payrollDTO.paymentDate()
        );
        Employee employee = employeeService.findById(String.valueOf(payrollDTO.employeeId()));

        payroll.setEmployee(employee);
        payroll.setId(Long.valueOf(id));

        return this.save(payroll);
    }

    public void delete(String id) {
        payrollRepository.deleteById(Long.valueOf(id));
    }
}
