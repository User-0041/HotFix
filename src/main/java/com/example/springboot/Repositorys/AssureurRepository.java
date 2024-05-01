package com.example.springboot.Repositorys;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.Entitys.Assureur;
@Repository
public interface AssureurRepository extends CrudRepository<Assureur,Integer > {

}