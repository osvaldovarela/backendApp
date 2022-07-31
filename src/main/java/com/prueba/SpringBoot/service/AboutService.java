package com.prueba.SpringBoot.service;

import com.prueba.SpringBoot.entity.About;
import com.prueba.SpringBoot.repository.AboutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AboutService implements iAboutService {

    @Autowired
    AboutRepository aboutRepository;

    public List<About> list() {
        return aboutRepository.findAll();
    }

    public Optional<About> getOne(Long id) {
        return aboutRepository.findById(id);
    }

    public void save(About about) {
        aboutRepository.save(about);
    }

    public void delete(Long id) {
        aboutRepository.deleteById(id);
    }

}
