package com.itc25.employeesystem.dtos.employee;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EmployeeUpdateDto {
    private final String firstName;
    private final String lastName;
    private final String gender;
}
