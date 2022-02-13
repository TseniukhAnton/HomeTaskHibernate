package com.hometask.hibernate.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="skills")
public class Skill {
    @Id
    @GeneratedValue
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;

    public Skill() {
    }
}
