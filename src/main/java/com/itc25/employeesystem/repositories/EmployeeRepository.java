package com.itc25.employeesystem.repositories;

import com.itc25.employeesystem.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, String> {

    @Query(value = """
            SELECT emp.EmployeeID, emp.TitleID, emp.BirthDate, emp.FirstName, emp.LastName,
            emp.Gender, emp.HiredDate, sal.Salary
            FROM Employees as emp
                 LEFT JOIN Salaries as sal ON (emp.EmployeeID = sal.EmployeeID)
            ORDER BY emp.EmployeeID;
             """, nativeQuery = true)
    List<Employee> findAllSalaryByEmployee();

    @Query(value = """
            SELECT *
            FROM Employees
            WHERE HiredDate LIKE CONCAT('%',:hiredDate,'%')""", nativeQuery = true)
    List<Employee> findAllEmployeeByYear(@Param("hiredDate") String year);

    @Query(value = """
            SELECT *
            FROM Employees
            WHERE Gender = :gender""", nativeQuery = true)
    List<Employee> findAllEmployeeByGender(@Param("gender") String gender);

    @Query(value = """
            SELECT e.EmployeeID, e.TitleID, e.BirthDate, e.FirstName, e.LastName,
            e.Gender, e.HiredDate, d.DepartmentName
            FROM Employees AS e
            	INNER JOIN DepartmentEmployee AS de
            		ON (e.EmployeeID = de.EmployeeID)
            	INNER JOIN departments AS d
            		ON (de.DepartmentID = d.DepartmentID)
            WHERE d.DepartmentName = :departmentName
            ORDER BY e.EmployeeID
            """, nativeQuery = true)
    List<Employee> findEmployeeByDepartmentId(@Param("departmentName") String departmentName);
}