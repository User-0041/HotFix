package com.example.springboot.Entitys;

import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
@Entity
@Data
public class Assureur extends User{
private String tel ;
@OneToMany(mappedBy = "assureur")
private Set<Voiture> cars; 
@ManyToOne
Assurance assurance;
}
