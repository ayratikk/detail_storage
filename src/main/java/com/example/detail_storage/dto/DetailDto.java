package com.example.detail_storage.dto;

import com.example.detail_storage.model.Technica;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor

public class DetailDto {

    private Long id;

    private String name;

    private Double cost;

}
