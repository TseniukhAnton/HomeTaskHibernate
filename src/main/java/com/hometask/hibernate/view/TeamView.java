package com.hometask.hibernate.view;

import com.hometask.hibernate.controller.TeamController;
import com.hometask.hibernate.model.Team;
import com.hometask.hibernate.model.TeamStatus;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class TeamView {
    private final Scanner scanner = new Scanner(new InputStreamReader(System.in));

    private final TeamController teamController = new TeamController();

    public Team getTeamFromController() {
        System.out.println("Please enter Team id to find it");
        Integer id = scanner.nextInt();
        System.out.println(teamController.getTeam(id));
        return teamController.getTeam(id);
    }

    public void deleteTeamFromController() {
        System.out.println("Please enter Team id to delete");
        Integer id = scanner.nextInt();
        teamController.deleteTeam(id);
    }

    public Team createTeamFromController() {
        System.out.println("Please enter Team name to create new");
        Team team = new Team();
        String name = scanner.nextLine();
//        Integer developerId = scanner.nextInt();
//        List<Developer> list = new ArrayList<>();
        //list.add(new HiberDeveloperRepoImpl().getById(developerId));
        team.setName(name);
       // team.setDevelopers(list);
        teamController.createTeam(team);
        return team;
    }

    public Team updateTeamFromController() {
        System.out.println("Please enter Team id, new name,status (ACTIVE,DELETED) for update");
        Integer id = scanner.nextInt();
        String newName = scanner.next();
        TeamStatus status = TeamStatus.valueOf(scanner.next());
        return teamController.updateTeam(id, newName, status);
    }

    public List<Team> getAllTeamsFromController() {
        System.out.println(teamController.getAllTeams());
        return teamController.getAllTeams();
    }
}
