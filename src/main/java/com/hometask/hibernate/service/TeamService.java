package com.hometask.hibernate.service;

import com.hometask.hibernate.model.Team;
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

    public Team save(Team team) {
        return teamRepository.save(team);
    }

    public Team update(Team team) {
        List<Team> list = getAll();
        for (Team currentteam : list) {
            if (currentteam.getId() == (team.getId())) {
                currentteam.setName(team.getName());
                currentteam.setTeamStatus(team.getTeamStatus());
                currentteam.setDevelopers(team.getDevelopers());
            }
        }
        return teamRepository.update(team);
    }
}
