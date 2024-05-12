package com.example.hrsimplified.dto;

import java.time.LocalDate;

public record FilterDTO (
        String name,
        String role,
        String department,
        LocalDate from,
        LocalDate to
){
}
