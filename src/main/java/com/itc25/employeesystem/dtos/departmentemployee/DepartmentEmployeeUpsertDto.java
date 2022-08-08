package com.itc25.employeesystem.dtos.departmentemployee;

import com.itc25.employeesystem.models.DepartmentEmployee;
import lombok.Data;

import java.io.Serializable;

@Data
public class DepartmentEmployeeUpsertDto implements Serializable {
    private final String employeeId;
    private final String departmentId;

}
