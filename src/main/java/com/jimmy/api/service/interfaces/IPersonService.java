package com.jimmy.api.service.interfaces;

import com.jimmy.api.model.Person;

import java.util.List;
import java.util.UUID;

public interface    IPersonService {

    List<Person> findAll();

    Person findById(UUID id);

    Person findByNit(Integer nit);

    Person save(Person person);

    Person update(UUID id, Person person);

    void delete(UUID id);
}