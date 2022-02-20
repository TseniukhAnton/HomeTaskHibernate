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

    public Skill save(Skill skill) {
        return skillRepository.save(skill);
    }

    public Skill update(Skill skill) {
       return skillRepository.update(skill);
    }
}
