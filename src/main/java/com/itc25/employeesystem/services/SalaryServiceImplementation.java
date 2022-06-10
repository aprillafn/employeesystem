package com.itc25.employeesystem.services;

import com.itc25.employeesystem.dtos.salary.SalaryGridDto;
import com.itc25.employeesystem.dtos.salary.SalaryUpsertDto;
import com.itc25.employeesystem.models.Employee;
import com.itc25.employeesystem.models.Salary;
import com.itc25.employeesystem.repositories.EmployeeRepository;
import com.itc25.employeesystem.repositories.SalaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class SalaryServiceImplementation implements SalaryService {

    @Autowired
    private SalaryRepository salaryRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<SalaryGridDto> findAllSalary(){
        Stream<Salary> stream = salaryRepository.findAll().stream();
        return SalaryGridDto.toList(stream.collect(Collectors.toList()));
    }

    @Override
    public SalaryGridDto insertSalary(SalaryUpsertDto newSalary){
        Employee employee = employeeRepository.findById(newSalary.getEmployeeId())
                .orElseThrow(()-> new IllegalArgumentException("Employee tidak ditemukan"));
        return SalaryGridDto.set(salaryRepository.save(newSalary.convert(employee)));
    }

    @Override
    public SalaryGridDto updateSalary(String id, SalaryUpsertDto salaryUpdateDto){
        Salary salary = salaryRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Salary tidak ditemukan"));
        salary.setSalary(salaryUpdateDto.getSalary());
        salaryRepository.save(salary);
        return SalaryGridDto.set(salary);
    }

    @Override
    public SalaryGridDto deleteSalaryById(@PathVariable String id) {
        Salary salary = salaryRepository.findById(id).orElseThrow(() -> new RuntimeException("Salary tidak ditemukan"));
        salaryRepository.deleteById(salary.getId());
        return SalaryGridDto.set(salary);
    }

}
