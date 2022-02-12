package com.hometask.hibernate.service;

import com.hometask.hibernate.model.Developer;
import com.hometask.hibernate.model.Skill;
import com.hometask.hibernate.model.Team;
import com.hometask.hibernate.model.TeamStatus;
import com.hometask.hibernate.repository.TeamRepository;

import java.util.List;

public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team getById(Integer id) {
        return teamRepository.getById(id);
    }

    public boolean deleteById(Integer id) {
        return teamRepository.deleteById(id);
    }

    public List<Team> getAll() {
        return teamRepository.getAll();
    }

    public void save(String name, List<Developer> developers, TeamStatus status) {
        Team team = new Team();
        team.setName(name);
        team.setDevelopers(developers);
        team.setTeamStatus(status);
        teamRepository.save(team);
    }

    public boolean update(Team team, List<Developer> developers, TeamStatus status) {
        if (developers != null) {
            team.setDevelopers(developers);
            team.setTeamStatus(status);
        }

        return teamRepository.update(team);
    }
}
