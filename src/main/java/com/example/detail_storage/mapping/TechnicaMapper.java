package com.example.detail_storage.mapping;

import com.example.detail_storage.dto.TechnicaDto;
import com.example.detail_storage.model.Technica;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TechnicaMapper extends BaseMapper<Technica, TechnicaDto> {
}
