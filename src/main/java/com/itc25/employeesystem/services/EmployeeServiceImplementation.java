package com.itc25.employeesystem.services;

import com.itc25.employeesystem.dtos.employee.EmployeeGridDto;
import com.itc25.employeesystem.dtos.employee.EmployeeInsertDto;
import com.itc25.employeesystem.dtos.employee.EmployeeSalaryGridDto;
import com.itc25.employeesystem.dtos.employee.EmployeeUpdateDto;
import com.itc25.employeesystem.models.Employee;
import com.itc25.employeesystem.repositories.EmployeeRepository;
import com.itc25.employeesystem.repositories.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class EmployeeServiceImplementation implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private TitleRepository titleRepository;

    @Override
    public List<EmployeeGridDto> getEmployee() {
        var stream = employeeRepository.findAll().stream();
        return EmployeeGridDto.toList(stream.collect(Collectors.toList()));
    }

    @Override
    public EmployeeGridDto insertEmployee(EmployeeInsertDto newEmployee) {
        var employee = employeeRepository.findById(newEmployee.getId()).isPresent();
        if (employee) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Employee sudah ada");
        }
        return EmployeeGridDto.set(employeeRepository.save(newEmployee.convert()));
    }

    @Override
    public EmployeeGridDto updateEmployee(String id, EmployeeUpdateDto updateEmployee) {
        var employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee tidak ditemukan"));
        employee.setFirstName(updateEmployee.getFirstName());
        employee.setLastName(updateEmployee.getLastName());
        employee.setGender(updateEmployee.getGender());
        employeeRepository.save(employee);
        return EmployeeGridDto.set(employee);
    }

    @Override
    public EmployeeGridDto deleteEmployeeById(@PathVariable String id) {
        var employee = employeeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Employee tidak ditemukan"));
        employeeRepository.deleteById(employee.getId());
        return EmployeeGridDto.set(employee);
    }

    @Override
    public List<EmployeeSalaryGridDto> findAllSalaryByEmployee() {
        return EmployeeSalaryGridDto.toList(employeeRepository.findAllSalaryByEmployee());
    }

    @Override
    public List<EmployeeGridDto> findAllEmployeeByYear(String year) {
        var employee = employeeRepository.findAllEmployeeByYear(year);
        if(employee.isEmpty()){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Employee tidak ditemukan");
        }
        return EmployeeGridDto.toList(employee);
    }

    @Override
    public List<EmployeeGridDto> findAllEmployeeByGender(String gender){
        return EmployeeGridDto.toList(employeeRepository.findAllEmployeeByGender(gender));
    }
}
