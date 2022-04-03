package com.example.detail_storage.dto;

import com.example.detail_storage.model.Technica;
import lombok.Data;

import java.util.Set;

@Data

public class DetailDto {
    private Long id;
    private String name;
    private Double cost;
    private Set<Technica> technics;
}
