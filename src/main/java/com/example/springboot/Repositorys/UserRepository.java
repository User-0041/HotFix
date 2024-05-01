package com.example.springboot.Repositorys;



import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot.Entitys.User;
@Repository
public interface UserRepository extends CrudRepository<User, Long> {



}