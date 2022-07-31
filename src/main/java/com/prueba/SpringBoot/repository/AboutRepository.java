package com.prueba.SpringBoot.repository;

import com.prueba.SpringBoot.entity.About;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AboutRepository extends JpaRepository<About, Long> {

}
