package com.itc25.employeesystem.dtos.departmentemployee;

import com.itc25.employeesystem.models.DepartmentEmployee;
import com.itc25.employeesystem.models.Employee;
import lombok.Data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class DepartmentEmployeeNameDto {
    private final String id;
    private final String fullName;
    private final String departmentName;

    public static DepartmentEmployeeNameDto set(Employee employee) {
        return new DepartmentEmployeeNameDto(
                employee.getId(),
                employee.getFirstName() + " " + employee.getLastName(),
                employee.getDepartments().stream().toList().get(0).getDepartmentName());
    }

    public static List<DepartmentEmployeeNameDto> toList(List<Employee> employees){
        List<DepartmentEmployeeNameDto> result = new ArrayList<>();
        for (Employee employee: employees) {
            result.add(set(employee));
        }
        return result;
    }

}
