package com.example.hrsimplified.domain;

import com.example.hrsimplified.dto.PayrollDTO;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity(name = "payroll")
@Table(name = "payroll")
public class Payroll {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private int salary;
    private int bonus;
    private float taxes;
    @Column(name = "payment_date")
    private LocalDate paymentDate;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public Payroll() {
    }

    public Payroll(int salary, int bonus, float taxes, LocalDate paymentDate) {
        this.salary = salary;
        this.bonus = bonus;
        this.taxes = taxes;
        this.paymentDate = paymentDate;
    }

    public Payroll(Long id, int salary, int bonus, float taxes, LocalDate paymentDate, Employee employee) {
        this.id = id;
        this.salary = salary;
        this.bonus = bonus;
        this.taxes = taxes;
        this.paymentDate = paymentDate;
        this.employee = employee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public float getTaxes() {
        return taxes;
    }

    public void setTaxes(float taxes) {
        this.taxes = taxes;
    }

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
