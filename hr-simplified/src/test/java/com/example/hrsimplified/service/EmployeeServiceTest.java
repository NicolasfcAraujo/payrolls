package com.example.hrsimplified.service;

import com.example.hrsimplified.domain.Employee;
import com.example.hrsimplified.dto.FilterDTO;
import com.example.hrsimplified.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EmployeeServiceTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @Autowired
    @InjectMocks
    private EmployeeService employeeService;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should return all employees for empty values and edge date")
    void filterCase1() {
        List<Employee> employeesList = getEmployees();

        FilterDTO filterDTO = new FilterDTO("", "", "", LocalDate.of(0,1, 1), LocalDate.of(9999,12,31));

        when(employeeRepository.findEmployeeByFilter(
                filterDTO.name(),
                filterDTO.role(),
                filterDTO.department(),
                filterDTO.from(),
                filterDTO.to()
        )).thenReturn(employeesList);

        List<Employee> filter = employeeService.filter(filterDTO);

        assertEquals(employeesList, filter);
    }

    private static List<Employee> getEmployees() {
        Employee employee1 = new Employee(1L, "Employee 1", "employee1@example.com", "role 1", "department 1", 3000, LocalDate.of(2023, 5,15), "9999999999999");
        Employee employee2 = new Employee(2L, "Employee 2", "employee2@example.com", "role 1", "department 2", 3000, LocalDate.of(2023, 2,15), "9999999999999");
        Employee employee3 = new Employee(2L, "Employee 3", "employee3@example.com", "role 2", "department 2", 3000, LocalDate.of(2022, 11,15), "9999999999999");

        return List.of(employee1, employee2, employee3);
    }
}