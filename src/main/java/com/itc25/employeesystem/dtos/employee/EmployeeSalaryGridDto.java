package com.itc25.employeesystem.dtos.employee;

import com.itc25.employeesystem.models.Employee;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class EmployeeSalaryGridDto {
    private final String id;
    private final String titleName;
    private final LocalDate birthDate;
    private final String fullName;
    private final String gender;
    private final LocalDate hiredDate;
    private final Integer salary;

    public static EmployeeSalaryGridDto set(Employee employee) {
        return new EmployeeSalaryGridDto(
                employee.getId(),
                employee.getTitleID().getTitleName(),
                employee.getBirthDate(),
                employee.getFirstName().concat(" ").concat(employee.getLastName()),
                employee.getGender(),
                employee.getHiredDate(),
                employee.getSalary() == null ? null : employee.getSalary().getSalary());
    }

    public static List<EmployeeSalaryGridDto> toList(List<Employee> employees) {
        return employees.stream()
                .map(EmployeeSalaryGridDto::set)
                .collect(Collectors.toList());
    }

}
