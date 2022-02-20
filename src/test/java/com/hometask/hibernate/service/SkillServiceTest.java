package com.hometask.hibernate.service;

import com.hometask.hibernate.model.Skill;
import com.hometask.hibernate.repository.SkillRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

class SkillServiceTest {
    private SkillService skillService;
    private SkillRepository skillRepositoryMock;

    @BeforeEach
    void setup() {
        this.skillRepositoryMock = mock(SkillRepository.class);
        this.skillService = new SkillService(skillRepositoryMock);
    }

    @Test
    void checkGetSkill() {
        Skill skill = new Skill();
        skill.setId(12);
        skill.setName("TestSkill");

        when(skillService.getById(12)).thenReturn(skill);
        Skill sk = skillService.getById(12);
        String name = sk.getName();
        String realName = "TestSkill";
        assertEquals(realName, name);
    }

    @Test
    void checkDeleteSkill() {
        when(skillService.deleteById(7)).thenReturn(true);
        assertTrue(skillService.deleteById(7));
    }

    @Test
    void checkSaveSkill() {
        Skill skill = new Skill();
        skill.setId(12);
        skill.setName("TestSkill");
        when(skillService.save(skill)).thenReturn(skill);
        Skill newSkill = skillService.save(skill);
        assertEquals(skillService.save(skill), newSkill);
    }

    @Test
    void checkUpdateSkill() {
        Skill skill = new Skill();
        skill.setId(25);
        skill.setName("TestNew");
        when(skillService.update(skill)).thenReturn(skill);

        assertEquals(skillService.update(skill), skill);
    }
}