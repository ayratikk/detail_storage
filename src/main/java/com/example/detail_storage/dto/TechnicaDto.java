package com.example.detail_storage.dto;

import com.example.detail_storage.model.Detail;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
public class TechnicaDto {

    private Long id;

    private String name;

    private Double cost;

    private String brand;


}
