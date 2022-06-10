package com.itc25.employeesystem.controllers;

import com.itc25.employeesystem.dtos.RestResponse;
import com.itc25.employeesystem.dtos.employee.EmployeeGridDto;
import com.itc25.employeesystem.dtos.employee.EmployeeInsertDto;
import com.itc25.employeesystem.dtos.employee.EmployeeSalaryGridDto;
import com.itc25.employeesystem.dtos.employee.EmployeeUpdateDto;
import com.itc25.employeesystem.services.EmployeeService;
import com.itc25.employeesystem.services.EmployeeServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employee")
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @GetMapping("find-all")
    public ResponseEntity<RestResponse<List<EmployeeGridDto>>> getEmployee() {
        return new ResponseEntity<>(
                new RestResponse<>(service.getEmployee(),
                        "Employee berhasil ditemukan",
                        200),
                HttpStatus.OK);
    }

    @PostMapping("insert")
    public ResponseEntity<RestResponse<EmployeeGridDto>> insertEmployee(@RequestBody EmployeeInsertDto newEmployee) {
        return new ResponseEntity<>(
                new RestResponse<>(service.insertEmployee(newEmployee),
                        "Employee berhasil ditambahkan",
                        200),
                HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<RestResponse<EmployeeGridDto>> updateEmployee(@PathVariable String id, @RequestBody EmployeeUpdateDto updateEmployee) {
        return new ResponseEntity<>(
                new RestResponse<>(service.updateEmployee(id, updateEmployee),
                        "Employee berhasil diupdate",
                        201),
                HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<RestResponse<EmployeeGridDto>> deleteEmployee(@PathVariable String id) {
        return new ResponseEntity<>(
                new RestResponse<>(service.deleteEmployeeById(id),
                        "Employee berhasil dihapus",
                        200),
                HttpStatus.OK);
    }

    @GetMapping("find-all-salary")
    public ResponseEntity<RestResponse<List<EmployeeSalaryGridDto>>> getSalaryByEmployee() {
        return new ResponseEntity<>(
                new RestResponse<>(service.findAllSalaryByEmployee(),
                        "Salary seluruh employee berhasil ditemukan",
                        200),
                HttpStatus.OK);
    }

    @GetMapping("{year}")
    public ResponseEntity<RestResponse<List<EmployeeGridDto>>> getEmployeeByYear(@PathVariable String year) {
        return new ResponseEntity<>(
                new RestResponse<>(service.findAllEmployeeByYear(year),
                        "Salary employee berhasil ditemukan",
                        200),
                HttpStatus.OK);
    }

    @GetMapping("gender/{gender}")
    public ResponseEntity<RestResponse<List<EmployeeGridDto>>> getEmployeeByGender(@PathVariable String gender){
        return new ResponseEntity<>(
                new RestResponse<>(service.findAllEmployeeByGender(gender),
                        "Employee berhasil ditemukan",
                        200),
                HttpStatus.OK);
    }
}
