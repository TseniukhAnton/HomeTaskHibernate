package com.hometask.hibernate.service;

import com.hometask.hibernate.model.Developer;
import com.hometask.hibernate.model.Skill;
import com.hometask.hibernate.repository.DeveloperRepository;

import java.util.List;

public class DeveloperService {
    private final DeveloperRepository developerRepository;

    public DeveloperService(DeveloperRepository developerRepository) {
        this.developerRepository = developerRepository;
    }

    public Developer getById(Integer id) {
        return developerRepository.getById(id);
    }

    public boolean deleteById(Integer id) {
        return developerRepository.deleteById(id);
    }

    public List<Developer> getAll() {
        return developerRepository.getAll();
    }

    public void save(String firstName, String lastName, List<Skill> skills) {
        Developer developer = new Developer();
        developer.setFirstName(firstName);
        developer.setLastName(lastName);
        developer.setSkills(skills);
        developerRepository.save(developer);
    }

    public boolean update(Developer developer, List<Skill> skills) {
        if (skills != null) {
            developer.setSkills(skills);
        }

        return developerRepository.update(developer);
    }

}
