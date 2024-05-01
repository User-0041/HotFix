package com.example.springboot.Repositorys;




import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.Entitys.Chouffeur;


@Repository
public interface ChouffeurRepository extends CrudRepository<Chouffeur , Long> {


   
}
    


