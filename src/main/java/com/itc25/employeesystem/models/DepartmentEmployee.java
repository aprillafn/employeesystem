package com.itc25.employeesystem.models;

import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "DepartmentEmployee")
public class DepartmentEmployee {
    @Id
    @Column(name = "EmployeeID", nullable = false, length = 5)
    private String id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EmployeeID", nullable = false)
    private Employee employees;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "DepartmentID")
    private Department departmentID;

    public DepartmentEmployee(Employee employee, Department department) {
        this.employees = employee;
        this.departmentID = department;
    }

}