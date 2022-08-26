package com.example.detail_storage.mapping;

import com.example.detail_storage.dto.DetailDto;
import com.example.detail_storage.model.Detail;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface DetailMapper {
    DetailDto domainToDto(Detail detail);

    Detail dtoToDomain(DetailDto detailDto);

    Collection<Detail> dtoListToDomainList(Collection<DetailDto> detailDtos);

    Collection<DetailDto> domainListToDtoList(Collection<Detail> details);

}
