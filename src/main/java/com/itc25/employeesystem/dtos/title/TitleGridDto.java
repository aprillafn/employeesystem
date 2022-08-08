package com.itc25.employeesystem.dtos.title;

import com.itc25.employeesystem.models.Title;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class TitleGridDto implements Serializable {
    private final String id;
    private final String titleName;

    public static TitleGridDto set(Title title) {
        return new TitleGridDto(title.getId(), title.getTitleName());
    }

    public static List<TitleGridDto> toList(List<Title> titles){
        return titles.stream()
                .map(TitleGridDto::set)
                .collect(Collectors.toList());
    }

}
