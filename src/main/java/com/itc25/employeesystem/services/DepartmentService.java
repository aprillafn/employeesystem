package com.itc25.employeesystem.services;

import com.itc25.employeesystem.dtos.department.DepartmentGridDto;
import com.itc25.employeesystem.dtos.department.DepartmentUpsertDto;

import java.util.List;

public interface DepartmentService {

    public List<DepartmentGridDto> findAllDepartment();
    public DepartmentGridDto insertDepartment(DepartmentUpsertDto newDepartment);
    public DepartmentGridDto updateDepartment(String id, DepartmentUpsertDto updateDepartment);
    public DepartmentGridDto deleteDepartmentById(String id);
}
