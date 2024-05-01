package com.example.springboot.Entitys;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Entity
@Data
public class Assurance {
@Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;
  private String name;

@OneToMany(mappedBy = "assurance")
  private Set<Assureur> assureurs;
}
