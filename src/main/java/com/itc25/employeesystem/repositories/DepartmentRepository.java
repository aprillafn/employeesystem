package com.itc25.employeesystem.repositories;

import com.itc25.employeesystem.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, String> {

}