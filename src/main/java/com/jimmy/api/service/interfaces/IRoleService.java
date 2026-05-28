package com.jimmy.api.service.interfaces;

import com.jimmy.api.model.Role;
import com.jimmy.api.repository.RoleRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IRoleService{
    List<Role> findAll();

    Role findById(UUID id);

    Optional<Role> findByName(String name);

    Role save(Role role);

    Role update(UUID id, Role role);

    void delete(UUID id);
}
