package com.itc25.employeesystem.dtos;

import lombok.Data;

@Data
public class RestResponse<T> {
    private final T data;
    private final String message;
    private final int status;
}
