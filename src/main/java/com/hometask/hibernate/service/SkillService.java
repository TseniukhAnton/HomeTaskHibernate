package com.hometask.hibernate.service;

import com.hometask.hibernate.model.Developer;
import com.hometask.hibernate.model.Skill;
import com.hometask.hibernate.model.Team;
import com.hometask.hibernate.repository.SkillRepository;

import java.util.List;

public class SkillService {
    private final SkillRepository skillRepository;

    public SkillService(SkillRepository skillRepository) {
        this.skillRepository = skillRepository;
    }

    public Skill getById(Integer id) {
        return skillRepository.getById(id);
    }

    public boolean deleteById(Integer id) {
        return skillRepository.deleteById(id);
    }

    public List<Skill> getAll() {
        return skillRepository.getAll();
    }

    public void save(String name) {
        Skill skill = new Skill();
        skill.setName(name);
        skillRepository.save(skill);
    }

    public boolean update(Skill skill, String name) {
        if (name != null) {
            skill.setName(name);
        }

        return skillRepository.update(skill);
    }
}
