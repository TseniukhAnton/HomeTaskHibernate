package com.hometask.hibernate;

import com.hometask.hibernate.view.DeveloperView;
import com.hometask.hibernate.view.SkillView;

public class Main {
    public static void main(String[] args) {
        DeveloperView developerView = new DeveloperView();
        developerView.createDeveloperFromController();

    }
}
