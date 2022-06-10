package com.itc25.employeesystem.dtos.employee;

import com.itc25.employeesystem.models.Employee;
import com.itc25.employeesystem.models.Salary;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class EmployeeGridDto implements Serializable {
    private final String id;
    private final String titleName;
    private final LocalDate birthDate;
    private final String fullName;
    private final String gender;
    private final LocalDate hiredDate;

    public static EmployeeGridDto set(Employee employee) {
        return new EmployeeGridDto(
                employee.getId(),
                employee.getTitleID().getTitleName(),
                employee.getBirthDate(),
                employee.getFirstName().concat(" ").concat(employee.getLastName()),
                employee.getGender(),
                employee.getHiredDate());
    }

    public static List<EmployeeGridDto> toList(List<Employee> employees) {
        return employees.stream()
                .map(EmployeeGridDto::set)
                .collect(Collectors.toList());
    }
}
