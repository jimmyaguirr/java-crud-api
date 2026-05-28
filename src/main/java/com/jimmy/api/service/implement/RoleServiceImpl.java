package com.jimmy.api.service.implement;

import com.jimmy.api.model.Role;
import com.jimmy.api.repository.RoleRepository;
import com.jimmy.api.service.interfaces.IRoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Service
@AllArgsConstructor
public class RoleServiceImpl  implements IRoleService {

    private final RoleRepository roleRepository;
    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(UUID id) {
        return roleRepository.findById(id).orElseThrow();
    }

    @Override
    public Optional<Role> findByName(String name) {
        return roleRepository.findByName(name);
    }


    @Override
    public Role save(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role update(UUID id, Role role) {
        Role existencia = findById(id);
        existencia.setName(role.getName()); // ← role minúscula = el parámetro
        return roleRepository.save(existencia);
    }

    @Override
    public void delete(UUID id) {
        Role existencia = findById(id); // consultar la persoina por id
        roleRepository.delete(existencia);
    }
}
