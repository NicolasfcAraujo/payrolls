package com.example.hrsimplified.dto;

import java.time.LocalDate;

public record EmployeeDTO(
        String name,
        String email,
        String role,
        String department,
        int salary,
        String phone,
        LocalDate hireDate) {
}
