package com.jimmy.api.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.UUID;
@RequiredArgsConstructor
@Getter
public class RoleDTO {

    // Getters
    @JsonProperty("RoleId")
    private UUID roleId;

    @JsonProperty("NombreRol")
    private String nombreRol;

    // Constructor
    public RoleDTO(UUID roleId, String nombreRol) {
        this.roleId = roleId;
        this.nombreRol = nombreRol;
    }

}
