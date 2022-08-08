package com.itc25.employeesystem.services;

import com.itc25.employeesystem.dtos.department.DepartmentGridDto;
import com.itc25.employeesystem.dtos.department.DepartmentUpsertDto;
import com.itc25.employeesystem.models.Department;
import com.itc25.employeesystem.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class DepartmentServiceImplementation implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<DepartmentGridDto> findAllDepartment(){
        var departmentStream = departmentRepository.findAll().stream();
        return DepartmentGridDto.toList(departmentStream.collect(Collectors.toList()));
    }

    @Override
    public DepartmentGridDto insertDepartment(DepartmentUpsertDto newDepartment){
        var department = departmentRepository.findById(newDepartment.getId()).isPresent();
        if (department) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Department sudah ada");
        }
        return DepartmentGridDto.set(departmentRepository.save(newDepartment.convert()));
    }

    @Override
    public DepartmentGridDto updateDepartment(String id, DepartmentUpsertDto updateDepartment){
        var department = departmentRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Department tidak ditemukan"));
        department.setDepartmentName(updateDepartment.getDepartmentName());
        departmentRepository.save(department);
        return DepartmentGridDto.set(department);
    }

    @Override
    public DepartmentGridDto deleteDepartmentById(@PathVariable String id) {
        var department = departmentRepository.findById(id).orElseThrow(() -> new RuntimeException("Department tidak ditemukan"));
        departmentRepository.deleteById(department.getId());
        return DepartmentGridDto.set(department);
    }
}
