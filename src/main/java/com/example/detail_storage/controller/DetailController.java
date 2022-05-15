package com.example.detail_storage.controller;

import com.example.detail_storage.dto.DetailDto;
import com.example.detail_storage.mapping.DetailMapper;
import com.example.detail_storage.model.Detail;
import com.example.detail_storage.service.DetailService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
@RequiredArgsConstructor
@RequestMapping("/details")
public class DetailController {

    // доступ к detailService;
    private final DetailService detailService;
    //доступ к мапперу
    private final DetailMapper mapper;

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DetailDto create(@RequestBody DetailDto detailDto) {
        // передаем экземпляр из внешнего мира в маппер, конвертируем в сущность, сохраняем объект
        // конвертируем сущность в дто и возвращаем в ответ на запрос
        return mapper.toDto(detailService.saveDetail(mapper.toDomain(detailDto)));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<DetailDto> getAllDetails() {
        //вызываем метод, туда передаем экземпляр класса Detail, а возвращается нам из метода маппера уже дто
        // и мы его возвращаем в ответ на запрос
        return mapper.toDtoCollection(detailService.getAll());
    }

    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DetailDto getDetail(@PathVariable Long id) {
        return mapper.toDto(detailService.findById(id));
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Collection<Detail> findByCost(@RequestParam("cost") Double cost) {
        return detailService.findByCost(cost);
    }

    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public DetailDto update(@RequestBody DetailDto detailDto) {
        return mapper.toDto(detailService.saveDetail(mapper.toDomain(detailDto)));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        detailService.removeDetail(id);
    }
}
