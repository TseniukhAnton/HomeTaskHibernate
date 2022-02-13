package com.hometask.hibernate;

import com.hometask.hibernate.view.SkillView;

public class Main {
    public static void main(String[] args) {
        SkillView skillView = new SkillView();
        skillView.createSkillFromController();
    }
}
