package com.itc25.employeesystem.controllers;

import com.itc25.employeesystem.dtos.RestResponse;
import com.itc25.employeesystem.dtos.departmentemployee.DepartmentEmployeeGridDto;
import com.itc25.employeesystem.dtos.departmentemployee.DepartmentEmployeeNameDto;
import com.itc25.employeesystem.dtos.departmentemployee.DepartmentEmployeeUpsertDto;
import com.itc25.employeesystem.services.DepartmentEmployeeService;
import com.itc25.employeesystem.services.DepartmentEmployeeServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("departmentemployee")
public class DepartmentEmployeeController {

    @Autowired
    private DepartmentEmployeeService departmentEmployeeService;

    @GetMapping("find-all")
    public ResponseEntity<RestResponse<List<DepartmentEmployeeGridDto>>> getDepartmentEmployee() {
        return new ResponseEntity<>(
                new RestResponse<>(departmentEmployeeService.findAllDepartmentEmployee(),
                        "Department Employee berhasil ditemukan",
                        200),
                HttpStatus.OK);
    }

    @PostMapping("insert")
    public ResponseEntity<RestResponse<DepartmentEmployeeGridDto>> insertDepartmentEmployee(@RequestBody DepartmentEmployeeUpsertDto newDepartmentEmployee) {
        return new ResponseEntity<>(
                new RestResponse<>(departmentEmployeeService.insertDepartmentEmployee(newDepartmentEmployee),
                        "Department Employee berhasil ditambahkan",
                        200),
                HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<RestResponse<DepartmentEmployeeGridDto>> deleteDepartmentEmployee(@PathVariable("id") String id) {
        return new ResponseEntity<>(
                new RestResponse<>(departmentEmployeeService.deleteDepartmentEmployee(id),
                        "Department Employee berhasil dihapus",
                        200),
                HttpStatus.OK);
    }

    @GetMapping("{departmentName}")
    public ResponseEntity<RestResponse<List<DepartmentEmployeeNameDto>>> getDepartmentEmployeeByDepartmentName(@PathVariable("departmentName") String departmentName) {
        return new ResponseEntity<>(
                new RestResponse<>(departmentEmployeeService.findAllDepartmentEmployeeName(departmentName),
                        "Department Employee berhasil ditemukan",
                        200),
                HttpStatus.OK);
    }
}
