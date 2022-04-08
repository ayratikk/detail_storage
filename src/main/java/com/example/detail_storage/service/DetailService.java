package com.example.detail_storage.service;

import com.example.detail_storage.model.Detail;
import com.example.detail_storage.repository.DetailRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DetailService {

    private final DetailRepository detailRepository;

    public List<Detail> getAll() {
        //дополнительная бизнес логика
        return detailRepository.findAll();
    }

    // получение детали по айди
    public Detail findById(Long id) {
        return detailRepository.getById(id);
    }

    //   добавление детали
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
