package com.hometask.hibernate.view;

import com.hometask.hibernate.controller.DeveloperController;
import com.hometask.hibernate.model.Developer;
import com.hometask.hibernate.model.Skill;
import com.hometask.hibernate.model.Team;
import com.hometask.hibernate.repository.hibernate.HiberDeveloperRepoImpl;
import com.hometask.hibernate.repository.hibernate.HiberSkillRepoImpl;
import com.hometask.hibernate.repository.hibernate.HiberTeamRepoImpl;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DeveloperView {

    private final Scanner scanner = new Scanner(new InputStreamReader(System.in));

    private final DeveloperController developerController = new DeveloperController();

    public Developer getDeveloperFromController() {
        System.out.println("Please enter Developer id to find it");
        Integer id = scanner.nextInt();
        System.out.println(developerController.getDeveloper(id));
        return developerController.getDeveloper(id);
    }

    public void deleteDeveloperFromController() {
        System.out.println("Please enter Developer id to delete");
        Integer id = scanner.nextInt();
        developerController.deleteDeveloper(id);
    }

    public Developer createDeveloperFromController() {
        System.out.println("Please enter Developer firstName, lastName, skillId1, skillId2, teamId to create new");
        Developer developer = new Developer();
        String firstName = scanner.next();
        String lastName = scanner.next();
        Integer skillId = scanner.nextInt();
        Integer skillId2 = scanner.nextInt();
        Integer teamId = scanner.nextInt();
        List<Skill> list = new ArrayList<>();
        list.add(new HiberSkillRepoImpl().getById(skillId));
        list.add(new HiberSkillRepoImpl().getById(skillId2));
        developer.setFirstName(firstName);
        developer.setLastName(lastName);
        developer.setSkills(list);
        developer.setTeam(new HiberTeamRepoImpl().getById(teamId));
        return developerController.createDeveloper(developer);
    }

    public Developer updateDeveloperFromController() {
        System.out.println("Please enter Developer id, new firstName, new lastName, new skillId, skillId2 for update");
        Integer id = scanner.nextInt();
        String firstName = scanner.next();
        String lastName = scanner.next();
        Integer skillId = scanner.nextInt();
        Integer skillId2 = scanner.nextInt();
        List<Skill> list = new HiberDeveloperRepoImpl().getById(id).getSkills();
        list.add(new HiberSkillRepoImpl().getById(skillId));
        list.add(new HiberSkillRepoImpl().getById(skillId2));
        return developerController.updateDeveloper(id, firstName, lastName, list);
    }

    public List<Developer> getAllDevelopersFromController() {
        System.out.println(developerController.getAllDevelopers());
        return developerController.getAllDevelopers();
    }
}
