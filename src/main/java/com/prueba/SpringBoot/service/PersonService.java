package com.prueba.SpringBoot.service;

import com.prueba.SpringBoot.entity.Person;
import com.prueba.SpringBoot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PersonService implements iPersonService {

    @Autowired
    PersonRepository personRepository;

    public List<Person> list() {
        return personRepository.findAll();
    }

    public Optional<Person> getOne(Long id) {
        return personRepository.findById(id);
    }

    public void save(Person person) {
        personRepository.save(person);
    }

    public void delete(Long id) {
        personRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return personRepository.existsById(id);
    }
}
