package com.itc25.employeesystem.dtos.departmentmanager;

import lombok.Data;

import java.io.Serializable;

@Data
public class DepartmentManagerUpsertDto implements Serializable {
    private final String departmentId;
    private final String employeeId;
}
