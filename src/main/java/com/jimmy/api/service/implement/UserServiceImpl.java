package com.jimmy.api.service.implement;

import com.jimmy.api.model.Person;
import com.jimmy.api.model.Role;
import com.jimmy.api.model.User;
import com.jimmy.api.model.UserRole;
import com.jimmy.api.model.dto.RoleDTO;
import com.jimmy.api.repository.PersonRepository;
import com.jimmy.api.repository.RoleRepository;
import com.jimmy.api.repository.UserRepository;

import com.jimmy.api.repository.UserRoleRepository;
import com.jimmy.api.service.interfaces.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@AllArgsConstructor
public class UserServiceImpl implements IUserService {
    private final RoleRepository roleRepository;
    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public List<RoleDTO> getRolesByUserId(UUID userId) {
        // 1. Verificar que el usuario existe
        userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User no encontrado: " + userId));

        // 2. Buscar todos los registros en la tabla pivote
        List<UserRole> userRoles = userRoleRepository.findByUserId(userId);

        // 3. Por cada registro, buscar el Role y convertir a DTO
        return userRoles.stream()
                .map(userRole -> {
                    Role role = roleRepository.findById(userRole.getRoleId())
                            .orElseThrow(() -> new RuntimeException("Role no encontrado: " + userRole.getRoleId()));
                    return new RoleDTO(role.getId(), role.getName());
                })
                .toList();
    }

    @Override
    public User findById(UUID id) {
        return userRepository.findById(id).orElseThrow();
    }

    @Override
    public List<User> findByName(String name) {
        return userRepository.findByName(name);
    }


    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(UUID id, User user) {
        User existencia = findById(id);          // ← U mayúscula
        existencia.setName(user.getName());
        existencia.setPassword(user.getPassword());
        existencia.setRoleId(user.getRoleId());
        existencia.setPersonId(user.getPersonId());
        return userRepository.save(existencia);
    }

    @Override
    public void delete(UUID id) {
        User existencia = findById(id); // consultar la persoina por id
        userRepository.delete(existencia); // hacer delete a la persona que se consulto
    }
}
