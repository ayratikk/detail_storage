package com.example.detail_storage.dto;

import com.example.detail_storage.model.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor

public class UserDto {
    private Long id;

    private String name;

    private Boolean active;

    private Set<Role> role;
}
