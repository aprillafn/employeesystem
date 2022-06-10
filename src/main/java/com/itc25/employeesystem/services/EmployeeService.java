package com.itc25.employeesystem.services;

import com.itc25.employeesystem.dtos.employee.EmployeeGridDto;
import com.itc25.employeesystem.dtos.employee.EmployeeInsertDto;
import com.itc25.employeesystem.dtos.employee.EmployeeSalaryGridDto;
import com.itc25.employeesystem.dtos.employee.EmployeeUpdateDto;

import java.util.List;

public interface EmployeeService {

    public List<EmployeeGridDto> getEmployee();
    public EmployeeGridDto insertEmployee(EmployeeInsertDto newEmployee);
    public EmployeeGridDto updateEmployee(String id, EmployeeUpdateDto updateEmployee);
    public EmployeeGridDto deleteEmployeeById(String id);
    public List<EmployeeSalaryGridDto> findAllSalaryByEmployee();
    public List<EmployeeGridDto> findAllEmployeeByYear(String year);
    public List<EmployeeGridDto> findAllEmployeeByGender(String gender);


}
