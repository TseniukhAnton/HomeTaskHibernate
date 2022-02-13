package com.hometask.hibernate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="developers")
public class Developer {
    @Id
    @GeneratedValue(generator = "id", strategy = GenerationType.IDENTITY)
    @Column(name="id", updatable = false, nullable = false)
    private int id;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;

    @OneToMany(targetEntity = Skill.class,mappedBy = "developer",
            cascade = CascadeType.ALL)
    private List<Skill> skills;

//    @ManyToOne(targetEntity = Team.class,fetch = FetchType.LAZY)
//    @JoinColumn(name = "team_id")
//    private Team team;

}
