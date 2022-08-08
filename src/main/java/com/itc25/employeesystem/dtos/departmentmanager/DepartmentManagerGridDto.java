package com.itc25.employeesystem.dtos.departmentmanager;

import com.itc25.employeesystem.models.DepartmentManager;
import lombok.Data;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class DepartmentManagerGridDto implements Serializable {
    private final String managerName;
    private final String departmentName;

    public static DepartmentManagerGridDto set(DepartmentManager departmentManager) {
        return new DepartmentManagerGridDto(
                departmentManager.getEmployees().getFirstName().concat(" ").concat(departmentManager.getEmployees().getLastName()),
                departmentManager.getDepartmentID().getDepartmentName());
    }

    public static List<DepartmentManagerGridDto> toList(List<DepartmentManager> departmentManagerList) {
        return departmentManagerList.stream()
                .map(DepartmentManagerGridDto::set)
                .collect(Collectors.toList());
    }

}
