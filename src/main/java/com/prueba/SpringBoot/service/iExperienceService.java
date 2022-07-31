package com.prueba.SpringBoot.service;

import com.prueba.SpringBoot.entity.Experience;
import java.util.List;
import java.util.Optional;

public interface iExperienceService {

    public List<Experience> list();

    public Optional<Experience> getOne(Long id);

    public void save(Experience experience);

    public void delete(Long id);

    public boolean existsById(Long id);
}
