package com.itc25.employeesystem.services;

import com.itc25.employeesystem.dtos.departmentemployee.DepartmentEmployeeGridDto;
import com.itc25.employeesystem.dtos.departmentemployee.DepartmentEmployeeNameDto;
import com.itc25.employeesystem.dtos.departmentemployee.DepartmentEmployeeUpsertDto;

import java.util.List;

public interface DepartmentEmployeeService {
    public List<DepartmentEmployeeGridDto> findAllDepartmentEmployee();
    public DepartmentEmployeeGridDto insertDepartmentEmployee(DepartmentEmployeeUpsertDto newDepartmentEmployee);
    public DepartmentEmployeeGridDto deleteDepartmentEmployee(String id);
    public List<DepartmentEmployeeNameDto> findAllDepartmentEmployeeName(String departmentName);
}
