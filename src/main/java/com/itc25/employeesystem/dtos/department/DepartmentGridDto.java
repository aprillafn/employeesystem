package com.itc25.employeesystem.dtos.department;

import com.itc25.employeesystem.models.Department;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class DepartmentGridDto implements Serializable {
    private final String id;
    private final String departmentName;

    public static DepartmentGridDto set(Department department){
        return new DepartmentGridDto(
                department.getId(), department.getDepartmentName());
    }

    public static List<DepartmentGridDto> toList(List<Department> departments){
        return departments.stream()
                .map(DepartmentGridDto::set)
                .collect(java.util.stream.Collectors.toList());
    }
}
