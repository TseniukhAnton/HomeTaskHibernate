package com.hometask.hibernate.service;

import com.hometask.hibernate.model.Developer;
import com.hometask.hibernate.model.Skill;
import com.hometask.hibernate.repository.DeveloperRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class DeveloperServiceTest {
    private DeveloperService developerService;
    private DeveloperRepository developerRepositoryMock;

    @BeforeEach
    void setup() {
        this.developerRepositoryMock = mock(DeveloperRepository.class);
        this.developerService = new DeveloperService(developerRepositoryMock);
    }

    @Test
    void checkGetDeveloper() {
        Developer developer = new Developer();
        List<Skill> skills = new ArrayList<>();
        developer.setId(97);
        developer.setFirstName("Anton");
        developer.setLastName("Tseniukh");
        developer.setSkills(skills);

        when(developerService.getById(97)).thenReturn(developer);
        Developer dev = developerService.getById(97);
        String name = dev.getFirstName();
        String realName = "Anton";
        assertEquals(realName, name);
    }

    @Test
    void checkDeleteDeveloper() {
        when(developerService.deleteById(72)).thenReturn(true);
        assertTrue(developerService.deleteById(72));
    }

    @Test
    void checkSaveDeveloper() {
        Developer developer = new Developer();
        List<Skill> skills = new ArrayList<>();
        developer.setId(97);
        developer.setFirstName("Anton");
        developer.setLastName("Tseniukh");
        developer.setSkills(skills);

        when(developerService.save(developer)).thenReturn(developer);
        Developer newDeveloper = developerService.save(developer);
        assertEquals(developerService.save(developer), newDeveloper);
    }

    @Test
    void checkUpdateDeveloper() {
        Developer developer = new Developer();
        List<Skill> skills = new ArrayList<>();
        developer.setId(97);
        developer.setFirstName("Anton");
        developer.setLastName("Tseniukh");
        developer.setSkills(skills);
        when(developerService.update(developer)).thenReturn(developer);

        assertEquals(developerService.update(developer), developer);
    }
}