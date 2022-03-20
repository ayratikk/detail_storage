package com.example.detail_storage.controller;

import com.example.detail_storage.model.Technica;
import com.example.detail_storage.service.TechnicService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequestMapping("/technica")

public class TechnicController {

    private final TechnicService technicService;

    public TechnicController(TechnicService technicService) {
        this.technicService = technicService;
    }

    @GetMapping("")
    @ResponseStatus(HttpStatus.OK)
    public Collection<Technica> getAllTechnica() {
        return technicService.getAll();
    }

    @GetMapping("del/{id}")
    public String removeTechica(@PathVariable Long id) {
        technicService.removeTechnica(id);
        return "Вы удалили запись под номером" + " " + id;
    }

    @PostMapping("/add")
    public Technica saveTechnica(@RequestBody Technica technica) {
        return technicService.saveTechnica(technica);
    }

    @GetMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public Technica getById(@PathVariable Long id) {
        return technicService.findById(id);
    }

    @GetMapping("/cost/{cost}")
    public Collection<Technica> findByCost(@PathVariable Double cost){
        return technicService.findByCost(cost);
    }
}
