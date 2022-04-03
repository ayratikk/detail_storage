package com.example.detail_storage.controller;

import com.example.detail_storage.dto.TechnicaDto;
import com.example.detail_storage.mapping.TechnicMapper;
import com.example.detail_storage.model.Technica;
import com.example.detail_storage.service.TechnicService;
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
@RequestMapping("/technica")

public class TechnicController {

    private final TechnicService technicService;

    public TechnicController(TechnicService technicService) {
        this.technicService = technicService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Technica> getAllTechnica() {
        return technicService.getAll();
    }

    @PutMapping
    public Technica update(@RequestBody Technica technica) {
        return technicService.saveTechnica(technica);
    }

    @DeleteMapping(value = "{id}",produces = MediaType.APPLICATION_JSON_VALUE)
    public String delete(@PathVariable Long id) {
        technicService.removeTechnica(id);
        return "Вы удалили запись под номером" + " " + id;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Technica save(@RequestBody Technica technica) {
        return technicService.saveTechnica(technica);
    }

    @GetMapping("/{id}")
    public TechnicaDto getById(@PathVariable Long id) {
        Technica technica = technicService.findById(id);
        return TechnicMapper.INSTANCE.toDTO(technica);
    }

    @GetMapping("/cost/{cost}")
    public Collection<Technica> findByCost(@PathVariable Double cost) {
        return technicService.findByCost(cost);
    }
}
