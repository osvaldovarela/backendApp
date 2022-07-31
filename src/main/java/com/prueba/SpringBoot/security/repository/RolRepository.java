package com.prueba.SpringBoot.security.repository;

import com.prueba.SpringBoot.security.entity.Rol;
import com.prueba.SpringBoot.security.enums.RolName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {

    Optional<Rol> findByRolName(RolName rolName);
}
