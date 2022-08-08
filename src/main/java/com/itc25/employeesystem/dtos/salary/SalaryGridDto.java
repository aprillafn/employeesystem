package com.itc25.employeesystem.dtos.salary;

import com.itc25.employeesystem.models.Salary;
import lombok.Data;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Data
public class SalaryGridDto implements Serializable {
    private final String employeeName;
    private final String salary;

    public static SalaryGridDto set(Salary salary) {
        //create number format indonesia
        Locale locale = new Locale("id", "ID");
        NumberFormat indo = NumberFormat.getCurrencyInstance(locale);
        return new SalaryGridDto(
                salary.getEmployees().getFirstName().concat(" ").concat(salary.getEmployees().getLastName()),
                indo.format(salary.getSalary()));
    }

    public static List<SalaryGridDto> toList(List<Salary> salaryList) {
        return salaryList.stream()
                .map(SalaryGridDto::set)
                .collect(Collectors.toList());
    }

}
