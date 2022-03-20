package com.example.detail_storage.service;

import com.example.detail_storage.model.Detail;
import com.example.detail_storage.repository.DetailRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class DetailService {
    private final DetailRepository detailRepository;
//авлптавлплапт
    public DetailService(DetailRepository detailRepository) {
        this.detailRepository = detailRepository;
    }

    public Collection<Detail> getAll() {
        //дополнительная бизнес логика
        return detailRepository.findAll();
    }

    // получение детали по айди
    public Detail findById(Long id) {
        return detailRepository.findById(id).get();
    }
    // добавление детали
    public Detail saveDetail(Detail detail) {
        return detailRepository.save(detail);
    }

    public void removeDetail(Long id) {
        detailRepository.deleteById(id);
    }

    public Collection<Detail> findByCost(Double cost) {
        return detailRepository.findByCostAfter(cost);
    }

}
