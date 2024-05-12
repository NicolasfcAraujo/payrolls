package com.example.hrsimplified.service;

import com.example.hrsimplified.domain.Employee;
import com.example.hrsimplified.dto.EmployeeDTO;
import com.example.hrsimplified.dto.FilterDTO;
import com.example.hrsimplified.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> findAll(){
        return employeeRepository.findAll();
    }

    public Employee findById(String id) throws Exception{
        Optional<Employee> checkedEmployee = employeeRepository.findById(Long.valueOf(id));

        if (checkedEmployee.isEmpty()){
            throw new Exception(String.format("Employee with ID %s not found!", id));
        }

        return checkedEmployee.get();
    }

    public Employee findByEmail(String email) throws Exception {
        Optional<Employee> foundEmployee = employeeRepository.findByEmail(email);

        if (foundEmployee.isEmpty()) {
            throw new Exception(String.format("Employee with e-mail %s not found!", email));
        }

        return foundEmployee.get();
    }

    public List<Employee> filter(FilterDTO filter) {
        return employeeRepository.findEmployeeByFilter(
                filter.name(),
                filter.role(),
                filter.department(),
                filter.from(),
                filter.to()
        );
    }

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee create(EmployeeDTO employee) {
        Employee newEmployee = new Employee(employee);

        return this.save(newEmployee);
    }

    public Employee update(EmployeeDTO employee, String id) throws Exception {
        Employee updatedEmployee = new Employee(employee);

        updatedEmployee.setId(Long.valueOf(id));

        return this.save(updatedEmployee);
    }

    public void delete(String id) {
        employeeRepository.deleteById(Long.valueOf(id));
    }
}
