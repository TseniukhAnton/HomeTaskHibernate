package com.hometask.hibernate.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="skills")
public class Skill {
    @Id
    @Column(name="id",updatable = false,nullable = false)
    @GeneratedValue(generator = "id", strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="name")
    private String name;

    @ManyToOne(targetEntity = Developer.class,fetch = FetchType.LAZY)
    @JoinColumn(name = "developer_id")
    private Developer developer;

}
