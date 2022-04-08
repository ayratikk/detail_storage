package com.example.detail_storage.mapping;

import com.example.detail_storage.dto.DetailDto;
import com.example.detail_storage.dto.TechnicaDto;
import com.example.detail_storage.model.Detail;
import com.example.detail_storage.model.Technica;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface TechnicaMapper  {
    TechnicaDto domainToDto(Technica technica);
    Technica dtoToDomain(TechnicaDto technicaDto);
    Collection<Technica> dtoListToDomainList(Collection<TechnicaDto>technicaDtos);
    Collection<TechnicaDto> domainListToDtoList(Collection<Technica> technicas);

}
