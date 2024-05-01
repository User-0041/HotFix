package com.example.springboot.Entitys;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity 

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Constat {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;

  private Date date;

  private String lieu;
  
  private String description ;
   @ManyToMany(mappedBy = "constats")
   private Set<Chouffeur> chouffeurs = new HashSet<>();

   @ManyToMany(mappedBy = "constats")
   private Set<Voiture> voitures = new HashSet<>();
}
