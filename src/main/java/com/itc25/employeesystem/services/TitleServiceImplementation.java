package com.itc25.employeesystem.services;

import com.itc25.employeesystem.dtos.title.TitleGridDto;
import com.itc25.employeesystem.dtos.title.TitleUpsertDto;
import com.itc25.employeesystem.models.Title;
import com.itc25.employeesystem.repositories.TitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class TitleServiceImplementation implements TitleService {

    @Autowired
    private TitleRepository titleRepository;

    @Override
    public List<TitleGridDto> findAllTitle() {
        Stream<Title> stream = titleRepository.findAll().stream();
        return TitleGridDto.toList(stream.collect(Collectors.toList()));
    }

    @Override
    public TitleGridDto insertTitle(TitleUpsertDto newTitle) {
        boolean title = titleRepository.findById(newTitle.getId()).isPresent();
        if (title) {
            throw new IllegalArgumentException("Title sudah ada");
        }
        return TitleGridDto.set(titleRepository.save(newTitle.convert()));
    }

    @Override
    public TitleGridDto updateTitle(String id, TitleUpsertDto updateTitle) {
        Title title = titleRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Title tidak ditemukan"));
        title.setTitleName(updateTitle.getTitleName());
        titleRepository.save(title);
        return TitleGridDto.set(title);
    }

    @Override
    public TitleGridDto deleteTitleById(@PathVariable String id) {
        Title title = titleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Title tidak ditemukan"));
        titleRepository.deleteById(title.getId());
        return TitleGridDto.set(title);
    }
}
