package com.prueba.SpringBoot.repository;

import com.prueba.SpringBoot.entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface SkillRepository extends JpaRepository<Skill, Long> {

}
