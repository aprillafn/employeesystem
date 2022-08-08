package com.itc25.employeesystem.dtos.employee;

import com.itc25.employeesystem.models.Employee;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class EmployeeInsertDto implements Serializable {
    private String id;
    private String titleId;
    private LocalDate birthDate;
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate hiredDate;

    public Employee convert() {
        return new Employee(
                id,
                titleId,
                birthDate,
                firstName,
                lastName,
                gender,
                hiredDate
        );
    }

}
