package com.prueba.SpringBoot.service;

import com.prueba.SpringBoot.entity.Experience;
import com.prueba.SpringBoot.repository.ExperienceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
@Service
public class ExperienceService implements iExperienceService {

    @Autowired
    ExperienceRepository experienceRepository;

    public List<Experience> list() {
        return experienceRepository.findAll();
    }

    public Optional<Experience> getOne(Long id) {
        return experienceRepository.findById(id);
    }

    public void save(Experience experience) {
        experienceRepository.save(experience);
    }

    public void delete(Long id) {
        experienceRepository.deleteById(id);
    }

    public boolean existsById(Long id) {
        return experienceRepository.existsById(id);
    }
}
