package com.example.detail_storage.repository;

import com.example.detail_storage.model.Detail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface DetailRepository extends JpaRepository<Detail, Long> {
    Collection<Detail> findByCostAfter(double cost);
}
