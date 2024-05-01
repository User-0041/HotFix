package com.example.springboot.Entitys;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;


@Entity
@Data
public class Chouffeur  extends User{
  private long permisDeConduire;
  private Date delivre;
  @ManyToMany
 private Set<Constat> constats = new HashSet<>();
}
