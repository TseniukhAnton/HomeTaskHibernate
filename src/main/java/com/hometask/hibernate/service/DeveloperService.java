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

    public Developer save(Developer developer) {
        return developerRepository.save(developer);
    }

    public Developer update(Developer developer) {
        return developerRepository.update(developer);
    }

}
