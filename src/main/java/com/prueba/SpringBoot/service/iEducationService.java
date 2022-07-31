package com.prueba.SpringBoot.service;

import com.prueba.SpringBoot.entity.Education;
import java.util.List;
import java.util.Optional;

public interface iEducationService {

    public List<Education> list();

    public Optional<Education> getOne(Long id);

    public void save(Education education);

    public void delete(Long id);

    public boolean existsById(Long id);
}
