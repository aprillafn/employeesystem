package com.itc25.employeesystem.services;

import com.itc25.employeesystem.dtos.departmentmanager.DepartmentManagerGridDto;
import com.itc25.employeesystem.dtos.departmentmanager.DepartmentManagerUpsertDto;
import com.itc25.employeesystem.models.Department;
import com.itc25.employeesystem.models.DepartmentManager;
import com.itc25.employeesystem.models.Employee;
import com.itc25.employeesystem.repositories.DepartmentManagerRepository;
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
public class DepartmentManagerServiceImplementation implements DepartmentManagerService {

    @Autowired
    private DepartmentManagerRepository departmentManagerRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<DepartmentManagerGridDto> findAllDepartmentManager(){
        var stream = departmentManagerRepository.findAll().stream();
        return DepartmentManagerGridDto.toList(stream.collect(Collectors.toList()));
    }

    @Override
    public DepartmentManagerGridDto insertDepartmentManager(DepartmentManagerUpsertDto newDepartmentManager){
        var employee = employeeRepository.findById(newDepartmentManager.getEmployeeId())
                .orElseThrow(() -> new IllegalArgumentException("Employee tidak ditemukan"));
        var department = departmentRepository.findById(newDepartmentManager.getDepartmentId())
                .orElseThrow(() -> new IllegalArgumentException("Department tidak ditemukan"));

        DepartmentManager departmentManager =
                new DepartmentManager(
                        employee,
                        department
                );


        return DepartmentManagerGridDto.set(departmentManagerRepository.save(departmentManager));
    }

    @Override
    public DepartmentManagerGridDto deleteDepartmentManager(String id) {
        var departmentManager = departmentManagerRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Tidak ditemukan"));

        departmentManagerRepository.delete(departmentManager);
        return DepartmentManagerGridDto.set(departmentManager);
    }

}
