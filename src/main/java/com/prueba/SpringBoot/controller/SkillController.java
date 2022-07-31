package com.prueba.SpringBoot.controller;

import com.prueba.SpringBoot.entity.Skill;
import com.prueba.SpringBoot.service.iSkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/skill")

public class SkillController {

    @Autowired

    private iSkillService skillserv;

    @PostMapping("/new")
    public Skill save(@RequestBody Skill skill) {
        skillserv.save(skill);
        return skill;
    }

    public void setSkillserv(iSkillService skillserv) {
        this.skillserv = skillserv;
    }

    @GetMapping("/")
    @ResponseBody
    public List<Skill> list() {
        return skillserv.list();
    }

    @GetMapping("/{id}")
    public Optional<Skill> getOne(@PathVariable Long id) {
        return skillserv.getOne(id);

    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        skillserv.delete(id);
    }

    @PutMapping("/edit/{id}")
    public Skill edit(@PathVariable Long id, @RequestBody Skill skill) {
        skillserv.getOne(id);

        skill.setValue(skill.getValue());
        skill.setText(skill.getText());
        skillserv.save(skill);
        return skill;
    }

}
