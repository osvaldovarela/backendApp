package com.prueba.SpringBoot.controller;

import com.prueba.SpringBoot.entity.Person;
import com.prueba.SpringBoot.service.iPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/person")

public class PersonController {

    @Autowired

    private iPersonService personserv;

    @PostMapping("/new")
    public Person save(@RequestBody Person person) {
        personserv.save(person);
        return person;
    }

    public void setPersonService(iPersonService personserv) {
        this.personserv = personserv;
    }

    @GetMapping("/")
    @ResponseBody
    public List<Person> list() {
        return personserv.list();
    }

    @GetMapping("/{id}")
    public Optional<Person> getOne(@PathVariable Long id) {
        return personserv.getOne(id);

    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        personserv.delete(id);
    }

    @PutMapping("/edit/{id}")
    public Person edit(@PathVariable Long id, @RequestBody Person person) {
        personserv.getOne(id);

        person.setName(person.getName());
        person.setDescription(person.getDescription());
        person.setCity(person.getCity());
        person.setCountry(person.getCountry());
        person.setEmail(person.getEmail());
        person.setBackImg(person.getBackImg());
        person.setProfileImg(person.getProfileImg());

        personserv.save(person);
        return person;
    }

}
