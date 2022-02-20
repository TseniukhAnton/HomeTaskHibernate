package com.hometask.hibernate.controller;

import com.hometask.hibernate.model.Developer;
import com.hometask.hibernate.model.Skill;
import com.hometask.hibernate.repository.DeveloperRepository;
import com.hometask.hibernate.repository.hibernate.HiberDeveloperRepoImpl;

import java.util.List;

public class DeveloperController {
    private final DeveloperRepository repo = new HiberDeveloperRepoImpl();

    public Developer getDeveloper(Integer id) {
        return repo.getById(id);
    }

    public void deleteDeveloper(Integer id) {
        repo.deleteById(id);
    }

    public Developer updateDeveloper(Integer id, String firstName, String lastName, List skills) {
        Developer developer = repo.getById(id);
        developer.setFirstName(firstName);
        developer.setLastName(lastName);
        List<Skill> newSkills = developer.getSkills();
        newSkills.add((Skill) skills.get(0));
        newSkills.add((Skill) skills.get(1));
        developer.setSkills(newSkills);
        repo.update(developer);
        return developer;
    }

    public Developer createDeveloper(Developer developer) {
        Developer newDeveloper = new Developer();
        newDeveloper.setFirstName(developer.getFirstName());
        newDeveloper.setLastName(developer.getLastName());
        newDeveloper.setSkills(developer.getSkills());
        newDeveloper.setTeam(developer.getTeam());
        repo.save(newDeveloper);
        return newDeveloper;
    }

    public List<Developer> getAllDevelopers() {
        return repo.getAll();
    }
}
