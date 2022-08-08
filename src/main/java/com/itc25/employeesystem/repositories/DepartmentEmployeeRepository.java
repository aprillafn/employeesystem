package com.itc25.employeesystem.repositories;

import com.itc25.employeesystem.models.DepartmentEmployee;
import com.itc25.employeesystem.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentEmployeeRepository extends JpaRepository<DepartmentEmployee, String> {

}