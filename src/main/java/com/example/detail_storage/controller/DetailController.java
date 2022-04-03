package com.example.detail_storage.controller;

import com.example.detail_storage.dto.DetailDto;
import com.example.detail_storage.mapping.DetailMapper;
import com.example.detail_storage.model.Detail;
import com.example.detail_storage.service.DetailService;
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
import java.util.List;

@RestController
@RequestMapping("/detail")
public class DetailController {

    // доступ к detailService;
    private DetailService detailService;

    // автоматическое внедрение экземпляра класса через конструктор
    public DetailController(DetailService detailService) {
        this.detailService = detailService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Detail> getAllDetails() {
        return detailService.getAll();
    }

    @GetMapping("/{id}")
    public DetailDto getDetail(@PathVariable Long id) {
        Detail detail = detailService.findById(id);
        return DetailMapper.INSTANCE.toDTO(detail);
    }

    @DeleteMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String delete(@PathVariable Long id) {
        detailService.removeDetail(id);
        return "Вы удалили запись под номером" + " " + id;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public Detail save(@RequestBody Detail detail) {
        return detailService.saveDetail(detail);
    }

    @PutMapping
    public Detail update(@RequestBody Detail detail) {
        return detailService.saveDetail(detail);
    }

    @GetMapping("/cost/{cost}")
    public Collection<Detail> findByCost(@PathVariable Double cost) {
        return detailService.findByCost(cost);
    }

}
