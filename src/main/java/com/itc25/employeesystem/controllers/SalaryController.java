package com.itc25.employeesystem.controllers;

import com.itc25.employeesystem.dtos.RestResponse;
import com.itc25.employeesystem.dtos.salary.SalaryGridDto;
import com.itc25.employeesystem.dtos.salary.SalaryUpsertDto;
import com.itc25.employeesystem.services.SalaryService;
import com.itc25.employeesystem.services.SalaryServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("salary")
public class SalaryController {

    @Autowired
    private SalaryService salaryService;

    @GetMapping("find-all")
    public ResponseEntity<RestResponse<List<SalaryGridDto>>> getSalary() {
        return new ResponseEntity<>(
                new RestResponse<>(salaryService.findAllSalary(),
                        "Salary berhasil ditemukan",
                        200),
                HttpStatus.OK);
    }

    @PostMapping("insert")
    public ResponseEntity<RestResponse<SalaryGridDto>> insertSalary(@RequestBody SalaryUpsertDto newSalary) {
        return new ResponseEntity<>(
                new RestResponse<>(salaryService.insertSalary(newSalary),
                        "Salary berhasil ditambahkan",
                        200),
                HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<RestResponse<SalaryGridDto>> updateSalary(@PathVariable String id, @RequestBody SalaryUpsertDto updateSalary) {
        return new ResponseEntity<>(
                new RestResponse<>(salaryService.updateSalary(id, updateSalary),
                        "Salary berhasil diupdate",
                        201),
                HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<RestResponse<SalaryGridDto>> deleteSalary(@PathVariable String id) {
        return new ResponseEntity<>(
                new RestResponse<>(salaryService.deleteSalaryById(id),
                        "Salary berhasil dihapus",
                        200),
                HttpStatus.OK);
    }

}
