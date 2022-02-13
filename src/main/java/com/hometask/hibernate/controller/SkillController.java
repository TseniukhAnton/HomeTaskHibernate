package com.hometask.hibernate.controller;

import com.hometask.hibernate.model.Developer;
import com.hometask.hibernate.model.Skill;
import com.hometask.hibernate.repository.DeveloperRepository;
import com.hometask.hibernate.repository.SkillRepository;
import com.hometask.hibernate.repository.hibernate.HiberDeveloperRepoImpl;
import com.hometask.hibernate.repository.hibernate.HiberSkillRepoImpl;

import java.util.List;

public class SkillController {

    private final SkillRepository repo = new HiberSkillRepoImpl();

    public Skill getSkill(Integer id) {
        return repo.getById(id);
    }

    public void deleteSkill(Integer id) {
        repo.deleteById(id);
    }

    public Skill updateSkill(Integer id, String name){
        List<Skill> skills = getAllSkills();
        Skill skill = skills.get(id);
        skill.setName(name);
        repo.update(skill);
        return skill;
    }

    public Skill createSkill(String name){
        Skill skill = new Skill();
        skill.setName(name);
        repo.save(skill);
        return skill;
    }

    public List<Skill> getAllSkills() {
        return repo.getAll();
    }
}
