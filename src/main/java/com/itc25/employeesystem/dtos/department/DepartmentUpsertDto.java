package com.itc25.employeesystem.dtos.department;

import com.itc25.employeesystem.models.Department;
import lombok.Data;

@Data
public class DepartmentUpsertDto {
    private final String id;
    private final String departmentName;

    public Department convert(){
        return new Department(
                id,
                departmentName
        );
    }

}
