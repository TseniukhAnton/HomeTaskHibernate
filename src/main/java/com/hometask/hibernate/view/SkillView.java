package com.hometask.hibernate.view;

import com.hometask.hibernate.controller.SkillController;
import com.hometask.hibernate.model.Skill;

import java.io.InputStreamReader;
import java.util.List;
import java.util.Scanner;

public class SkillView {
    private final Scanner scanner = new Scanner(new InputStreamReader(System.in));

    private final SkillController skillController = new SkillController();

    public Skill getSkillFromController() {
        System.out.println("Please enter Skill id to find it");
        Integer id = scanner.nextInt();
        System.out.println(skillController.getSkill(id));
        return skillController.getSkill(id);
    }

    public void deleteSkillFromController() {
        System.out.println("Please enter Skill id to delete");
        Integer id = scanner.nextInt();
        skillController.deleteSkill(id);
    }

    public Skill createSkillFromController() {
        System.out.println("Please enter Skill name for creation");
        String name = scanner.next();
        return skillController.createSkill(name);
    }

    public Skill updateSkillFromController() {
        System.out.println("Please enter Skill id, new name to update");
        Integer id = scanner.nextInt();
        String name = scanner.next();
        return skillController.updateSkill(id, name);
    }

    public List<Skill> getAllSkillsFromController() {
        System.out.println(skillController.getAllSkills());
        return skillController.getAllSkills();
    }
}
