package com.itc25.employeesystem.models;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Employees")
public class Employee {
    @Id
    @Column(name = "EmployeeID", nullable = false, length = 5)
    private String id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "TitleID", nullable = false)
    private Title titleID;

    @Column(name = "BirthDate", nullable = false)
    private LocalDate birthDate;

    @Column(name = "FirstName", nullable = false, length = 20)
    private String firstName;

    @Column(name = "LastName", length = 20)
    private String lastName;

    @Column(name = "Gender", nullable = false, length = 10)
    private String gender;

    @Column(name = "HiredDate", nullable = false)
    private LocalDate hiredDate;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "employees")
    private Salary salary;

    @ManyToMany
    @JoinTable(name = "DepartmentManager",
            joinColumns = @JoinColumn(name = "EmployeeID"),
            inverseJoinColumns = @JoinColumn(name = "DepartmentID"))
    private Set<Department> departmentManager = new LinkedHashSet<>();

    @ManyToMany
    @JoinTable(name = "DepartmentEmployee",
            joinColumns = @JoinColumn(name = "EmployeeID"),
            inverseJoinColumns = @JoinColumn(name = "DepartmentID"))
    private Set<Department> departments = new LinkedHashSet<>();

    public Employee(String id, String titleID, LocalDate birthDate, String firstName, String lastName, String gender, LocalDate hiredDate) {
        this.id = id;
        this.titleID = new Title(titleID);
        this.birthDate = birthDate;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.hiredDate = hiredDate;
    }

    public Employee(String id) {
        this.id = id;
    }

}