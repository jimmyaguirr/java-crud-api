package com.jimmy.api.service.interfaces;

import com.jimmy.api.model.Person;
import com.jimmy.api.model.User;
import com.jimmy.api.model.dto.RoleDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

    public interface IUserService {

        List<User> findAll();
        List<RoleDTO> getRolesByUserId(UUID userId);

        User findById(UUID id);


        List<User> findByName(String name);


        User save(User user);

        User update(UUID id, User user);

        void delete(UUID id);
    }

