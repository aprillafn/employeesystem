package com.itc25.employeesystem.dtos.title;

import com.itc25.employeesystem.models.Title;
import lombok.Data;

import java.io.Serializable;

@Data
public class TitleUpsertDto implements Serializable {
    private final String id;
    private final String titleName;

    public Title convert(){
        return new Title(
                id,
                titleName
        );
    }

}
