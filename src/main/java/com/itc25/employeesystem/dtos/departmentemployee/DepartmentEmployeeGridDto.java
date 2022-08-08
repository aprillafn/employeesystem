package com.itc25.employeesystem.dtos.departmentemployee;

import com.itc25.employeesystem.models.DepartmentEmployee;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class DepartmentEmployeeGridDto implements Serializable {
    private final String employeeName;
    private final String departmentName;

    public static DepartmentEmployeeGridDto set(DepartmentEmployee departmentEmployee) {
        return new DepartmentEmployeeGridDto(
                departmentEmployee.getEmployees().getFirstName().concat(" ").concat(departmentEmployee.getEmployees().getLastName()),
                departmentEmployee.getDepartmentID().getDepartmentName());
    }

    public static List<DepartmentEmployeeGridDto> toList(List<DepartmentEmployee> departmentEmployeeList) {
        return departmentEmployeeList.stream()
                .map(DepartmentEmployeeGridDto::set)
                .collect(Collectors.toList());
    }

}
