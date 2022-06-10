package com.itc25.employeesystem.services;

import com.itc25.employeesystem.dtos.departmentemployee.DepartmentEmployeeGridDto;
import com.itc25.employeesystem.dtos.departmentemployee.DepartmentEmployeeNameDto;
import com.itc25.employeesystem.dtos.departmentemployee.DepartmentEmployeeUpsertDto;
import com.itc25.employeesystem.models.Department;
import com.itc25.employeesystem.models.DepartmentEmployee;
import com.itc25.employeesystem.models.Employee;
import com.itc25.employeesystem.repositories.DepartmentEmployeeRepository;
import com.itc25.employeesystem.repositories.DepartmentRepository;
import com.itc25.employeesystem.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DepartmentEmployeeServiceImplementation implements DepartmentEmployeeService {

    @Autowired
    private DepartmentEmployeeRepository departmentEmployeeRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<DepartmentEmployeeGridDto> findAllDepartmentEmployee() {
        Stream<DepartmentEmployee> stream = departmentEmployeeRepository.findAll().stream();
        return DepartmentEmployeeGridDto.toList(stream.collect(Collectors.toList()));
    }

    @Override
    public DepartmentEmployeeGridDto insertDepartmentEmployee(DepartmentEmployeeUpsertDto newDepartmentEmployee) {
        Employee employee = employeeRepository.findById(newDepartmentEmployee.getEmployeeId())
                .orElseThrow(() -> new IllegalArgumentException("Employee tidak ditemukan"));
        Department department = departmentRepository.findById(newDepartmentEmployee.getDepartmentId())
                .orElseThrow(() -> new IllegalArgumentException("Department tidak ditemukan"));

        DepartmentEmployee departmentEmployee = new DepartmentEmployee(
                employee,
                department);

        return DepartmentEmployeeGridDto.set(departmentEmployeeRepository.save(departmentEmployee));
    }

    @Override
    public DepartmentEmployeeGridDto deleteDepartmentEmployee(String id) {
        DepartmentEmployee departmentEmployee = departmentEmployeeRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tidak ditemukan"));

        departmentEmployeeRepository.delete(departmentEmployee);
        return DepartmentEmployeeGridDto.set(departmentEmployee);
    }

    @Override
    public List<DepartmentEmployeeNameDto> findAllDepartmentEmployeeName(String departmentName) {
        return DepartmentEmployeeNameDto.toList(employeeRepository.findEmployeeByDepartmentId(departmentName));
    }
}
