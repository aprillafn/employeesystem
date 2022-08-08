package com.itc25.employeesystem.models;

import lombok.*;

import javax.persistence.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class DepartmentManager {
    @Id
    @Column(name = "EmployeeID", nullable = false, length = 5)
    private String id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "EmployeeID", nullable = false)
    private Employee employees;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "DepartmentID", nullable = false)
    private Department departmentID;

    public DepartmentManager(Employee employees, Department departmentID) {
        this.employees = employees;
        this.departmentID = departmentID;
    }
}