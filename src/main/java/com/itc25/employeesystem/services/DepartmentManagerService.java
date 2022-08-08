package com.itc25.employeesystem.services;

import com.itc25.employeesystem.dtos.departmentmanager.DepartmentManagerGridDto;
import com.itc25.employeesystem.dtos.departmentmanager.DepartmentManagerUpsertDto;

import java.util.List;

public interface DepartmentManagerService {

    public List<DepartmentManagerGridDto> findAllDepartmentManager();
    public DepartmentManagerGridDto insertDepartmentManager(DepartmentManagerUpsertDto newDepartmentManager);
    public DepartmentManagerGridDto deleteDepartmentManager(String id);

}
