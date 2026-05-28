package com.jimmy.api.service.interfaces;

import com.jimmy.api.model.dto.RoleDTO;
import com.jimmy.api.model.UserRole;

import java.util.List;
import java.util.UUID;

public interface IUserRoleService {

    List<RoleDTO> getRolesByUserId(UUID userId);

    UserRole assignRole(UUID userId, UUID roleId); // asignar rol a usuario

    void removeRole(UUID id); // quitar rol a usuario
}