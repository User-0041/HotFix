package com.example.springboot.Entitys;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import lombok.Data;
@Entity
@Inheritance(strategy =InheritanceType.TABLE_PER_CLASS)
@Data

public class User {
  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  private Long id;

  private String name;

  private String email;
  
  private String motPasse;


}