package com.example.detail_storage.controller;

import com.example.detail_storage.dto.TechnicaDto;
import com.example.detail_storage.mapping.TechnicaMapper;
import com.example.detail_storage.model.Technica;
import com.example.detail_storage.service.TechnicService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/technics")

public class TechnicController {

    private final TechnicService technicService;
    private final TechnicaMapper mapper;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<TechnicaDto> getAllTechnica() {
        return mapper.domainListToDtoList(technicService.getAll());
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public TechnicaDto update(@RequestBody TechnicaDto technicaDto) {

        return mapper.domainToDto(technicService.saveTechnica(mapper.dtoToDomain(technicaDto)));
    }

    @DeleteMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HttpStatus delete(@PathVariable Long id) {
        technicService.removeTechnica(id);
        return HttpStatus.NO_CONTENT;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public TechnicaDto create(@RequestBody TechnicaDto technicaDto) {
        return mapper.domainToDto(technicService.saveTechnica(mapper.dtoToDomain(technicaDto)));
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public TechnicaDto getTechnic(@PathVariable Long id) {
        return mapper.domainToDto(technicService.findById(id));
    }

    @GetMapping("/cost/{cost}")
    public Collection<Technica> findByCost(@PathVariable Double cost) {
        return technicService.findByCost(cost);
    }
}
