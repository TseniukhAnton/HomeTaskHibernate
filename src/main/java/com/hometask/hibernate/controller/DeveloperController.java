package com.hometask.hibernate.controller;

import com.hometask.hibernate.model.Developer;
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

    public Developer updateDeveloper(Integer id, String firstName, String lastName, List skills){
        List<Developer> developers = getAllDevelopers();
        Developer developer = developers.get(id);
        developer.setFirstName(firstName);
        developer.setLastName(lastName);
        developer.setSkills(skills);
        repo.update(developer);
        return developer;
    }

    public Developer createDeveloper(String firstName, String lastName, List skills){
        Developer developer = new Developer();
        developer.setFirstName(firstName);
        developer.setLastName(lastName);
        developer.setSkills(skills);
        repo.save(developer);
        return developer;
    }

    public List<Developer> getAllDevelopers() {
        return repo.getAll();
    }
}
