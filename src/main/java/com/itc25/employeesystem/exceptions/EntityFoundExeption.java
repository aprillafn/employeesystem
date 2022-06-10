package com.itc25.employeesystem.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class EntityFoundExeption extends ResponseStatusException {


    public EntityFoundExeption(String reason) {
        super(HttpStatus.BAD_REQUEST, reason);
    }
}
