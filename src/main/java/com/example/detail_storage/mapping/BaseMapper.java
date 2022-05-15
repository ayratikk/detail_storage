package com.example.detail_storage.mapping;

import java.util.Collection;

public interface BaseMapper<DOMAIN, DTO> {
    DTO toDto(DOMAIN domain);

    DOMAIN toDomain(DTO dto);

    Collection<DOMAIN> toDomainCollection(Collection<DTO> dtos);

    Collection<DTO> toDtoCollection(Collection<DOMAIN> domains);
}
