package com.itc25.employeesystem.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Departments")
public class Department {
    @Id
    @Column(name = "DepartmentID", nullable = false, length = 5)
    private String id;

    @Column(name = "DepartmentName", nullable = false, length = 50)
    private String departmentName;

    public Department(String departmentId) {
        this.id = departmentId;
    }

}