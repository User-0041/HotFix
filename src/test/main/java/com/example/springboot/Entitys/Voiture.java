package com.example.springboot.Entitys;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data

public class Voiture {
    @Id
    private Long id;

    private String name ;
    @ManyToOne
    private Assureur assureur;
 @ManyToMany
 private Set<Constat> constats = new HashSet<>();
}
