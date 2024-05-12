package com.example.hrsimplified.domain;

import com.example.hrsimplified.dto.EmployeeDTO;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "employee")
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(unique = true)
    private String email;
    private String role;
    private String department;
    private int salary;
    @Column(name = "hire_date")
    private LocalDate hireDate;
    private String phone;

    public Employee(){}

    public Employee(EmployeeDTO employee) {
        this.name = employee.name();
        this.email = employee.email();
        this.role = employee.role();
        this.department = employee.department();
        this.salary = employee.salary();
        this.hireDate = employee.hireDate();
        this.phone = employee.phone();
    }

    public Employee(Long id, String name, String email, String role, String department, int salary, LocalDate hireDate, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.role = role;
        this.department = department;
        this.salary = salary;
        this.hireDate = hireDate;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
