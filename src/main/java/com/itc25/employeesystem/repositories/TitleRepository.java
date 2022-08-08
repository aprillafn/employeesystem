package com.itc25.employeesystem.repositories;

import com.itc25.employeesystem.models.Title;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TitleRepository extends JpaRepository<Title, String> {

}