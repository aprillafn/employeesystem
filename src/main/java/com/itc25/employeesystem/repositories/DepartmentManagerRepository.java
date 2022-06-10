package com.itc25.employeesystem.repositories;

import com.itc25.employeesystem.models.DepartmentManager;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentManagerRepository extends JpaRepository<DepartmentManager, String> {
}