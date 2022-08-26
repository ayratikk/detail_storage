package com.example.detail_storage.service;

import com.example.detail_storage.common.exception.ExceptionHandler;
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
    private final ExceptionHandler handler;

    public List<Detail> getAll() {
        //дополнительная бизнес логика
        return detailRepository.findAll();
    }

    // получение детали по айди
    public Detail findById(Long id) {
        if (id != 0) {
            return detailRepository.getById(id);
        } else {
            return null;
        }

    }

    //   добавление детали
    public Detail saveDetail(Detail detail) {
        if (detail.getName() == null || detail.getCost() == null || detail == null) {
            return null;
        }
        return detailRepository.save(detail);
    }

    public void removeDetail(Long id) {
        detailRepository.deleteById(id);
    }

    public Collection<Detail> findByCost(Double cost) {
        return detailRepository.findByCostAfter(cost);
    }

}
