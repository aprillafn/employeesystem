package com.itc25.employeesystem.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Salaries")
public class Salary {
    @Id
    @Column(name = "EmployeeID", nullable = false, length = 5)
    private String id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EmployeeID", nullable = false)
    private Employee employees;

    @Column(name = "Salary", nullable = false)
    private Integer salary;

    public Salary(Employee id, Integer salary) {
        this.employees = id;
        this.salary = salary;
    }
}