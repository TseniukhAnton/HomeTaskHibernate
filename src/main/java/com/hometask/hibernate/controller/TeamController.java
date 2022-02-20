package com.hometask.hibernate.controller;

import com.hometask.hibernate.model.Developer;
import com.hometask.hibernate.model.Team;
import com.hometask.hibernate.model.TeamStatus;
import com.hometask.hibernate.repository.TeamRepository;
import com.hometask.hibernate.repository.hibernate.HiberTeamRepoImpl;

import java.util.List;

public class TeamController {
    private final TeamRepository repo = new HiberTeamRepoImpl();

    public Team getTeam(Integer id) {
        return repo.getById(id);
    }

    public void deleteTeam(Integer id) {
        repo.deleteById(id);
    }

    public Team updateTeam(Integer id, String name, TeamStatus status){
        Team team = repo.getById(id);
        team.setName(name);
        team.setTeamStatus(status);
        repo.update(team);
        return team;
    }

    public Team createTeam(Team team){
        team.setTeamStatus(TeamStatus.ACTIVE);
        repo.save(team);
        return team;
    }

    public List<Team> getAllTeams() {
        return repo.getAll();
    }
}
