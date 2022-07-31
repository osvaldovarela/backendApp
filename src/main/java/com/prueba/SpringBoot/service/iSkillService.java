package com.prueba.SpringBoot.service;

import com.prueba.SpringBoot.entity.Skill;
import java.util.List;
import java.util.Optional;

public interface iSkillService {

    public List<Skill> list();

    public Optional<Skill> getOne(Long id);

    public void save(Skill skill);

    public void delete(Long id);

    public boolean existsById(Long id);

}
