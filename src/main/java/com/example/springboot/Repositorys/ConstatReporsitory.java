package com.example.springboot.Repositorys;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.Entitys.Constat;
@Repository
public interface ConstatReporsitory extends CrudRepository<Constat, Integer> {


}