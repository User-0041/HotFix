package com.example.springboot.Repositorys;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.Entitys.Voiture;


@Repository
public interface VoitureRepository extends CrudRepository<Voiture, Long> {


}