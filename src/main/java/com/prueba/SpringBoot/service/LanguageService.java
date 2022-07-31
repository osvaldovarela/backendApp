package com.prueba.SpringBoot.service;

import com.prueba.SpringBoot.entity.Language;
import com.prueba.SpringBoot.repository.LanguageRepository;
import com.prueba.SpringBoot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class LanguageService implements iLanguageService {

    @Autowired
    LanguageRepository languageRepository;
    @Autowired
    PersonRepository personRepository;

    public List<Language> list() {
        return languageRepository.findAll();
    }

    public Optional<Language> getOne(Long id) {
        return languageRepository.findById(id);
    }

    @Override
    public void save(Language language) {
        languageRepository.save(language);

    }

    public void delete(Long id) {
        languageRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return languageRepository.existsById(id);
    }
}
