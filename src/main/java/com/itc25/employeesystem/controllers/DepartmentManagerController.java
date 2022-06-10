package com.itc25.employeesystem.controllers;

import com.itc25.employeesystem.dtos.RestResponse;
import com.itc25.employeesystem.dtos.departmentmanager.DepartmentManagerGridDto;
import com.itc25.employeesystem.dtos.departmentmanager.DepartmentManagerUpsertDto;
import com.itc25.employeesystem.services.DepartmentManagerService;
import com.itc25.employeesystem.services.DepartmentManagerServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("departmentmanager")
public class DepartmentManagerController {

    @Autowired
    private DepartmentManagerService departmentManagerService;

    @GetMapping("find-all")
    public ResponseEntity<RestResponse<List<DepartmentManagerGridDto>>> getDepartmentManager() {
        return new ResponseEntity<>(
                new RestResponse<>(departmentManagerService.findAllDepartmentManager(),
                        "Department Manager berhasil ditemukan",
                        200),
                HttpStatus.OK);
    }

    @PostMapping("insert")
    public ResponseEntity<RestResponse<DepartmentManagerGridDto>> insertDepartmentManager(@RequestBody DepartmentManagerUpsertDto newDepartmentManager) {
        return new ResponseEntity<>(
                new RestResponse<>(departmentManagerService.insertDepartmentManager(newDepartmentManager),
                        "Department Manager berhasil ditambahkan",
                        200),
                HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<RestResponse<DepartmentManagerGridDto>> deleteDepartmentManager(@PathVariable("id") String id) {
        return new ResponseEntity<>(
                new RestResponse<>(departmentManagerService.deleteDepartmentManager(id),
                        "Department Manager berhasil dihapus",
                        200),
                HttpStatus.OK);
    }
}
