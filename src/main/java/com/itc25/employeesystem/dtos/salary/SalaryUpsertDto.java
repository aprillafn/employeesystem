package com.itc25.employeesystem.dtos.salary;

import com.itc25.employeesystem.models.Employee;
import com.itc25.employeesystem.models.Salary;
import lombok.Data;

@Data
public class SalaryUpsertDto {
    private String employeeId;
    private Integer salary;

    public Salary convert(Employee employee) {
        return new Salary(
                employee,
                salary
        );
    }
}
