package com.example.detail_storage.mapping;

import com.example.detail_storage.dto.TechnicaDto;
import com.example.detail_storage.model.Technica;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface TechnicMapper {
    TechnicMapper INSTANCE = Mappers.getMapper(TechnicMapper.class);

    TechnicaDto toDTO(Technica technica);
}
