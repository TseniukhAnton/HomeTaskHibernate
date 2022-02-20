package com.hometask.hibernate.view;

import java.io.InputStreamReader;
import java.util.Scanner;

public class CommonView {
    private final Scanner scanner = new Scanner(new InputStreamReader(System.in));

    private final SkillView skillView = new SkillView();
    private final DeveloperView developerView = new DeveloperView();
    private final TeamView teamView = new TeamView();

    public void start() {
        System.out.println("What would you like to do? Create, Read, Update or Delete?");
        String sc = scanner.next();
        if (sc.equals("Create")) {
            System.out.println("What would you like to create? Skill, Developer or Team?");
            String create = scanner.next();
            if (create.equals("Skill")) {
                skillView.createSkillFromController();
                System.out.println("New Skill was created");
                skillView.getSkillFromController();
            } else if (create.equals("Developer")) {
                developerView.createDeveloperFromController();
                System.out.println("New Developer was created");
                developerView.getDeveloperFromController();
            } else if (create.equals("Team")) {
                teamView.createTeamFromController();
                System.out.println("New Team was created");
                teamView.getTeamFromController();
            } else {
                System.out.println("Wrong command!");
            }
        } else if (sc.equals("Read")) {
            System.out.println("What would you like to read? Skill, Developer or Team?");
            String read = scanner.next();
            if (read.equals("Skill")) {
                skillView.getSkillFromController();
            } else if (read.equals("Developer")) {
                developerView.getDeveloperFromController();
            } else if (read.equals("Team")) {
                teamView.getTeamFromController();
            } else {
                System.out.println("Wrong command!");
            }
        } else if (sc.equals("Update")) {
            System.out.println("What would you like to update? Skill, Developer or Team?");
            String update = scanner.next();
            if (update.equals("Skill")) {
                skillView.updateSkillFromController();
                System.out.println("Skill was updated");
            } else if (update.equals("Developer")) {
                developerView.updateDeveloperFromController();
                System.out.println("Developer was updated");
                developerView.getDeveloperFromController();
            } else if (update.equals("Team")) {
                teamView.updateTeamFromController();
                System.out.println("Team was updated");
                teamView.getTeamFromController();
            } else {
                System.out.println("Wrong command!");
            }
        } else if (sc.equals("Delete")) {
            System.out.println("What would you like to delete? Skill, Developer or Team?");
            String delete = scanner.next();
            if (delete.equals("Skill")) {
                skillView.deleteSkillFromController();
                System.out.println("Skill was deleted");
            } else if (delete.equals("Developer")) {
                developerView.deleteDeveloperFromController();
                System.out.println("Developer was deleted");
            } else if (delete.equals("Team")) {
                teamView.deleteTeamFromController();
                System.out.println("Team was deleted");
            } else {
                System.out.println("Wrong command!");
            }
        } else {
            System.out.println("Wrong command!");
        }
    }
}
