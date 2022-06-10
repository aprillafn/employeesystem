package com.itc25.employeesystem.services;

import com.itc25.employeesystem.dtos.salary.SalaryGridDto;
import com.itc25.employeesystem.dtos.salary.SalaryUpsertDto;

import java.util.List;

public interface SalaryService {

    public List<SalaryGridDto> findAllSalary();
    public SalaryGridDto insertSalary(SalaryUpsertDto newSalary);
    public SalaryGridDto updateSalary(String id, SalaryUpsertDto salaryUpdateDto);
    public SalaryGridDto deleteSalaryById(String id);



}
