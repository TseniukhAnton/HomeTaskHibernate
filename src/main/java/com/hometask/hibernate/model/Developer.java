package com.hometask.hibernate.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@ToString
@Entity
@Table(name="developers")
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
            CascadeType.DETACH})
    @JoinTable(name = "developer_skills", joinColumns = @JoinColumn(name = "developer_id"),
    inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skills;

    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
            CascadeType.DETACH})
    @JoinColumn(name = "team_id")
    private Team team;

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", skills=" + skills +
                ", team=" + team +
                '}';
    }
}
