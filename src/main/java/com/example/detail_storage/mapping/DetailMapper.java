package com.example.detail_storage.mapping;

import com.example.detail_storage.dto.DetailDto;
import com.example.detail_storage.model.Detail;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DetailMapper {
    DetailMapper INSTANCE = Mappers.getMapper(DetailMapper.class);

    DetailDto toDTO(Detail detail);

}
