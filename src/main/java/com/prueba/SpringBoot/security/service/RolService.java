package com.prueba.SpringBoot.security.service;


import com.prueba.SpringBoot.security.entity.Rol;
import com.prueba.SpringBoot.security.enums.RolName;
import com.prueba.SpringBoot.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import javax.transaction.Transactional;

@Service
@Transactional
public class RolService {
    
    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRoleName(RolName rolName){
        return rolRepository.findByRolName(rolName);
    }

    public void save(Rol rol){
        rolRepository.save(rol);
    }
}