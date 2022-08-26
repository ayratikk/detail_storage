package com.example.detail_storage.mapping;

import com.example.detail_storage.dto.TechnicaDto;
import com.example.detail_storage.dto.UserDto;
import com.example.detail_storage.model.Technica;
import com.example.detail_storage.model.User;
import org.mapstruct.Mapper;

import java.util.Collection;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto domainToDto(User user);

    User dtoToDomain(UserDto userDto);

    Collection<User> dtoListToDomainList(Collection<UserDto> userDtos);

    Collection<UserDto> domainListToDtoList(Collection<User> user);

}
