package com.example.detail_storage.controller;

import com.example.detail_storage.model.Detail;
import com.example.detail_storage.service.DetailService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("/detail")
public class DetailController {

    // доступ к detailService;
    private final DetailService detailService;

    // автоматическое внедрение экземпляра класса через конструктор
    public DetailController(DetailService detailService) {
        this.detailService = detailService;
    }

    @GetMapping("")
    public Collection<Detail> getAllDetails() {
        return detailService.getAll();
    }

    @GetMapping("{id}")
    public Object getDetail(@PathVariable Long id) {
        if (id == null) {
            return HttpStatus.BAD_REQUEST;
        }
        return detailService.findById(id);
    }

    @GetMapping("del/{id}")
    public String deleteDetail(@PathVariable Long id) {
        detailService.removeDetail(id);
        return "Вы удалили запись под номером" + " " + id;
    }

    @PostMapping("/add")
    public Detail saveDetail(@RequestBody Detail detail) {
        return detailService.saveDetail(detail);
    }

    @GetMapping("/cost/{cost}")
    public Collection<Detail> findByCost(@PathVariable Double cost) {
        return detailService.findByCost(cost);
    }

}
