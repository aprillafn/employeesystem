package com.itc25.employeesystem.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "Titles")
public class Title {
    @Id
    @Column(name = "TitleID", nullable = false, length = 5)
    private String id;

    @Column(name = "TitleName", nullable = false, length = 50)
    private String titleName;

    public Title(String id) {
        this.id = id;
    }
}