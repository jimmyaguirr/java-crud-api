package com.jimmy.api.service.implement;

import com.jimmy.api.model.dto.RoleDTO;
import com.jimmy.api.model.Role;
import com.jimmy.api.model.UserRole;
import com.jimmy.api.repository.RoleRepository;
import com.jimmy.api.repository.UserRepository;
import com.jimmy.api.repository.UserRoleRepository;
import com.jimmy.api.service.interfaces.IUserRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserRoleServiceImpl implements IUserRoleService {

    private final UserRoleRepository userRoleRepository;
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public List<RoleDTO> getRolesByUserId(UUID userId) {
        // 1. Verify that the user exists
        userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User no encontrado: " + userId));

        // 2. Search the pivot table for all user roles
        List<UserRole> userRoles = userRoleRepository.findByUserId(userId);

        // 3. Convert to DTO
        return userRoles.stream()
                .map(userRole -> {
                    Role role = roleRepository.findById(userRole.getRoleId())
                            .orElseThrow(() -> new RuntimeException("Role no encontrado: " + userRole.getRoleId()));
                    return new RoleDTO(role.getId(), role.getName());
                })
                .toList();
    }

    @Override
    public UserRole assignRole(UUID userId, UUID roleId) {
        // 1. Verify that both exist
        userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User no encontrado: " + userId));

        roleRepository.findById(roleId)
                .orElseThrow(() -> new RuntimeException("Role no encontrado: " + roleId));

        // 2. Create the record in the pivot
        UserRole userRole = new UserRole();
        userRole.setUserId(userId);
        userRole.setRoleId(roleId);

        return userRoleRepository.save(userRole);
    }

    @Override
    public void removeRole(UUID id) {
        UserRole userRole = userRoleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Asignación no encontrada: " + id));
        userRoleRepository.delete(userRole);
    }
}