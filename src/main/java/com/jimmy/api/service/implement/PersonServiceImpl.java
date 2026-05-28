package com.jimmy.api.service.implement;

import com.jimmy.api.model.Person;
import com.jimmy.api.repository.PersonRepository;
import com.jimmy.api.service.interfaces.IPersonService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
@AllArgsConstructor
public class PersonServiceImpl implements IPersonService {

    private final PersonRepository personRepository;

    @Override
    public List<Person> findAll() {
        return personRepository.findAll();
    }

    @Override
    public Person findById(UUID id) {
        return personRepository.findById(id).orElseThrow();
    }

        @Override
        public Person findByNit(Integer nit) {
            return personRepository.findByNit(nit).orElseThrow();
        }

    @Override
    public Person save(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person update(UUID id, Person person) {
        Person existencia =findById(id); // consultar la persona por id ,en ese momento
        existencia.setAge(person.getAge());// capturar datos-consultar y guardar
        existencia.setName(person.getName());
        existencia.setTypeNit(person.getTypeNit());
        existencia.setNit(person.getNit());
        return personRepository.save(existencia); // guardar dato que se modifico

    }

    @Override
    public void delete(UUID id) {
        personRepository.deleteById(id); // hacer delete a la persona que se consulto
    }
}
