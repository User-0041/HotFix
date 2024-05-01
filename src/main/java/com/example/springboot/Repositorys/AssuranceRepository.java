package com.example.springboot.Repositorys;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.Entitys.Assurance;
@Repository
public interface AssuranceRepository extends CrudRepository<Assurance, Long>  {

 
}