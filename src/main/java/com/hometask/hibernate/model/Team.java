package com.hometask.hibernate.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name="teams")
public class Team {
    @Id
    @Column(name="id", updatable = false, nullable = false)
    @GeneratedValue(generator = "id", strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;
    @Column(name = "team_status")
    TeamStatus teamStatus;
    @Column(name = "developers")
    @OneToMany(targetEntity = Developer.class,mappedBy = "team", cascade = CascadeType.ALL)
    private List<Developer> developers;
}
