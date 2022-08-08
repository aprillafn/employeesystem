package com.itc25.employeesystem.services;

import com.itc25.employeesystem.dtos.title.TitleGridDto;
import com.itc25.employeesystem.dtos.title.TitleUpsertDto;
import com.itc25.employeesystem.models.Title;

import java.util.List;

public interface TitleService {

    public List<TitleGridDto> findAllTitle();
    public TitleGridDto insertTitle(TitleUpsertDto newTitle);
    public TitleGridDto updateTitle(String id, TitleUpsertDto updateTitle);
    public TitleGridDto deleteTitleById(String id);
}
