package com.example.detail_storage.mapping;

import com.example.detail_storage.dto.DetailDto;
import com.example.detail_storage.model.Detail;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DetailMapper extends BaseMapper<Detail, DetailDto> {
}
