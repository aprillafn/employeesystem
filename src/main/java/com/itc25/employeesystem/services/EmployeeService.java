package com.itc25.employeesystem.services;

import com.itc25.employeesystem.dtos.employee.EmployeeGridDto;
import com.itc25.employeesystem.dtos.employee.EmployeeInsertDto;
import com.itc25.employeesystem.dtos.employee.EmployeeSalaryGridDto;
import com.itc25.employeesystem.dtos.employee.EmployeeUpdateDto;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface EmployeeService {

    List<EmployeeGridDto> getEmployee();

    EmployeeGridDto insertEmployee(EmployeeInsertDto newEmployee);

    EmployeeGridDto updateEmployee(String id, EmployeeUpdateDto updateEmployee);

    EmployeeGridDto deleteEmployeeById(@PathVariable String id);

    public List<EmployeeSalaryGridDto> findAllSalaryByEmployee();
    public List<EmployeeGridDto> findAllEmployeeByYear(String year);
    public List<EmployeeGridDto> findAllEmployeeByGender(String gender);


}
