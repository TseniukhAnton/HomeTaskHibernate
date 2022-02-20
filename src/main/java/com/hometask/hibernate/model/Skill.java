package com.hometask.hibernate.model;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@ToString
@Entity
@Table(name="skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH,
            CascadeType.DETACH})
    @JoinTable(name = "developer_skills", joinColumns = @JoinColumn(name = "skill_id"),
            inverseJoinColumns = @JoinColumn(name = "developer_id")
    )
    private List<Developer> developers;

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
