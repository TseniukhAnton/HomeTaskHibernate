package com.hometask.hibernate.service;

import com.hometask.hibernate.model.Team;
import com.hometask.hibernate.repository.TeamRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class TeamServiceTest {
    private TeamService teamService;
    private TeamRepository teamRepositoryMock;

    @BeforeEach
    void setup() {
        teamRepositoryMock = mock(TeamRepository.class);
        this.teamService = new TeamService(teamRepositoryMock);
    }

    @Test
    void checkGetTeam() {
        Team team = new Team();
        team.setId(5);
        team.setName("TestTeam");

        when(teamService.getById(5)).thenReturn(team);
        Team tk = teamService.getById(5);
        String name = tk.getName();
        String realName = "TestTeam";
        assertEquals(realName, name);
    }

    @Test
    void checkDeleteTeam() {
        when(teamService.deleteById(7)).thenReturn(true);
        assertTrue(teamService.deleteById(7));
    }

    @Test
    void checkSaveTeam() {
        Team team = new Team();
        team.setId(555);
        team.setName("Team555");
        when(teamService.save(team)).thenReturn(team);
        Team newTeam = teamService.save(team);
        assertEquals(teamService.save(team), newTeam);
    }

    @Test
    void checkUpdateTeam() {
        Team team = new Team();
        team.setId(77);
        team.setName("DreamTeam");
        when(teamService.update(team)).thenReturn(team);

        assertEquals(teamService.update(team), team);
    }
}