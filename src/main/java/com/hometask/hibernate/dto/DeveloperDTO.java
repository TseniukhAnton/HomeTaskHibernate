package com.hometask.hibernate.dto;

import com.hometask.hibernate.model.Skill;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
@Builder
public class DeveloperDTO {
   private int id;
   private String firstName;
   private String lastName;
   private List<Skill> skills;
}
