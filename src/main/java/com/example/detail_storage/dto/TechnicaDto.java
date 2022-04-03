package com.example.detail_storage.dto;

import com.example.detail_storage.model.Detail;
import lombok.Data;

import java.util.Set;

@Data

public class TechnicaDto {

    private Long id;
    private String name;
    private Double cost;
    private String brand;
    private Set<Detail> details;
}
