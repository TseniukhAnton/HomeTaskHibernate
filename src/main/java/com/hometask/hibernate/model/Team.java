package com.hometask.hibernate.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@ToString
@Entity
@Table(name = "teams")
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "teamStatus")
    TeamStatus teamStatus;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH},
            mappedBy = "team")
    private List<Developer> developers;

    @Override
    public String toString() {
        return "Team{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", teamStatus=" + teamStatus +
                '}';
    }
}

