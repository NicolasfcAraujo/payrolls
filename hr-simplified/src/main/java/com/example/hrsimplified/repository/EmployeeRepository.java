package com.example.hrsimplified.repository;

import com.example.hrsimplified.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT e FROM employee e WHERE" +
            "(:name IS NULL OR e.name LIKE %:name%)" +
            "AND (:role IS NULL OR e.role LIKE %:role%)" +
            "AND (:department IS NULL OR e.department LIKE %:department%)" +
            "AND (:from IS NULL OR e.hireDate >= :from)" +
            "AND (:to IS NULL OR e.hireDate <= :to)"
    )
    List<Employee> findEmployeeByFilter(String name, String role, String department, LocalDate from, LocalDate to);

    Optional<Employee> findByEmail(String email);
}
