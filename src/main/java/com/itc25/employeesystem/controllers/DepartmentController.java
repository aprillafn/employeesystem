package com.itc25.employeesystem.controllers;

import com.itc25.employeesystem.dtos.RestResponse;
import com.itc25.employeesystem.dtos.department.DepartmentGridDto;
import com.itc25.employeesystem.dtos.department.DepartmentUpsertDto;
import com.itc25.employeesystem.services.DepartmentService;
import com.itc25.employeesystem.services.DepartmentServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("department")
public class DepartmentController {

    @Autowired
    private DepartmentService service;

    @GetMapping("find-all")
    public ResponseEntity<RestResponse<List<DepartmentGridDto>>> findAllDepartment(){
        return new ResponseEntity<>(
                new RestResponse<>(service.findAllDepartment(),
                        "Department berhasil ditemukan",
                        200),
                HttpStatus.OK);
    }

    @PostMapping("insert")
    public ResponseEntity<RestResponse<DepartmentGridDto>> insertNewDepartment(@RequestBody DepartmentUpsertDto newDepartment){
        return new ResponseEntity<>(
                new RestResponse<>(service.insertDepartment(newDepartment),
                        "Department berhasil ditambahkan",
                        200),
                HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<RestResponse<DepartmentGridDto>> updateDepartment(@PathVariable String id, @RequestBody DepartmentUpsertDto updateDepartment){
        return new ResponseEntity<>(
                new RestResponse<>(service.updateDepartment(id, updateDepartment),
                        "Department berhasil diupdate",
                        201),
                HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<RestResponse<DepartmentGridDto>> deleteDepartment(@ PathVariable String id){
        return new ResponseEntity<>(
                new RestResponse<>(service.deleteDepartmentById(id),
                        "Department berhasil dihapus",
                        200),
                HttpStatus.OK);
    }
}

