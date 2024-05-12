package com.example.hrsimplified.dto;

import java.time.LocalDate;

public record PayrollDTO(
        int salary,
        int bonus,
        float taxes,
        LocalDate paymentDate,
        Long employeeId
) {
}
