package com.hometask.hibernate.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="skills")
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;
    @Column(name="name")
    private String name;

//    @ManyToOne(targetEntity = Developer.class,fetch = FetchType.LAZY)
//    @JoinColumn(name = "developer_id")
//    private Developer developer;

}
