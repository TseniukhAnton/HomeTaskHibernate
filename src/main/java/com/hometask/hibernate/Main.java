package com.hometask.hibernate;

import com.hometask.hibernate.model.Skill;
import com.hometask.hibernate.repository.hibernate.HiberSkillRepoImpl;
import com.hometask.hibernate.view.SkillView;

public class Main {
    public static void main(String[] args) {
//        SkillView skillView = new SkillView();
//        skillView.createSkillFromController();
        HiberSkillRepoImpl hiberSkillRepo = new HiberSkillRepoImpl();
        Skill skill = new Skill();
        skill.setName("Java");
        hiberSkillRepo.save(skill);
    }
}
