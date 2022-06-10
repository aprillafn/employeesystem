package com.itc25.employeesystem.controllers;

import com.itc25.employeesystem.dtos.RestResponse;
import com.itc25.employeesystem.dtos.title.TitleGridDto;
import com.itc25.employeesystem.dtos.title.TitleUpsertDto;
import com.itc25.employeesystem.services.TitleService;
import com.itc25.employeesystem.services.TitleServiceImplementation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("title")
public class TitleController {

    @Autowired
    private TitleService service;

    @GetMapping("find-all")
    public ResponseEntity<RestResponse<List<TitleGridDto>>> findAllTitle(){
        return new ResponseEntity<>(
                new RestResponse<>(service.findAllTitle(),
                        "Title berhasil ditemukan",
                        200),
                HttpStatus.OK);
    }

    @PostMapping("insert")
    public ResponseEntity<RestResponse<TitleGridDto>> insertTitle(@RequestBody TitleUpsertDto newTitle){
        return new ResponseEntity<>(
                new RestResponse<>(service.insertTitle(newTitle),
                        "Title berhasil ditambahkan",
                        200),
                HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<RestResponse<TitleGridDto>> updateTitle(@PathVariable String id, @RequestBody TitleUpsertDto updateTitle){
        return new ResponseEntity<>(
                new RestResponse<>(service.updateTitle(id, updateTitle),
                        "Title berhasil diupdate",
                        201),
                HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<RestResponse<TitleGridDto>> deleteTitle(@PathVariable String id){
        return new ResponseEntity<>(
                new RestResponse<>(service.deleteTitleById(id),
                        "Title berhasil dihapus",
                        200),
                HttpStatus.OK);
    }
}
