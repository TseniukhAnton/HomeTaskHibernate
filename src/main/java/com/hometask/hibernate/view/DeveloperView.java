package com.hometask.hibernate.view;

import com.hometask.hibernate.controller.DeveloperController;
import com.hometask.hibernate.model.Developer;
import com.hometask.hibernate.model.Skill;
import com.hometask.hibernate.repository.hibernate.HiberDeveloperRepoImpl;
import com.hometask.hibernate.repository.hibernate.HiberSkillRepoImpl;

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
        System.out.println("Please enter Developer id");
        Integer id = scanner.nextInt();
        System.out.println(developerController.getAllDevelopers());
        developerController.deleteDeveloper(id);
        System.out.println(developerController.getAllDevelopers());
    }

    public Developer createDeveloperFromController() {
        System.out.println("Please enter Developer firstName, lastName, skillId, skillId2");
        String firstName = scanner.next();
        String lastName = scanner.next();
        Integer skillId = scanner.nextInt();
        Integer skillId2 = scanner.nextInt();
        List<Skill> list = new ArrayList<>();
        list.add(new HiberSkillRepoImpl().getById(skillId));
        list.add(new HiberSkillRepoImpl().getById(skillId2));
        return developerController.createDeveloper(firstName, lastName, list);
    }

    public Developer updateDeveloperFromController() {
        System.out.println("Please enter Developer id, new firstName, new lastName, new skillId, skillId2");
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
