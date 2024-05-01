package com.example.springboot.Services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.Entitys.Chouffeur;
import com.example.springboot.Repositorys.ChouffeurRepository;

@Service
public class ChouffeurService {

    @Autowired
    private ChouffeurRepository chouffeurRepository;

    public List<Chouffeur> getAllChouffeur() {
        return (List<Chouffeur>) chouffeurRepository.findAll();
    }

    public Chouffeur getChouffeurById(Long id) {
        return chouffeurRepository.findById(id).orElse(null);
    }

    public Chouffeur addChouffeur(Chouffeur chouffeur) {
        return chouffeurRepository.save(chouffeur);
    }

    public Chouffeur updateChouffeur(Long id, Chouffeur newChouffeur) {
        Chouffeur existingChouffeur = chouffeurRepository.findById(id).orElse(null);
        if (existingChouffeur != null) {
            existingChouffeur.setName(newChouffeur.getName());
            existingChouffeur.setPermisDeConduire(newChouffeur.getPermisDeConduire());
            existingChouffeur.setDelivre(newChouffeur.getDelivre());
            return chouffeurRepository.save(existingChouffeur);
        }
        return null;
    }

    public boolean deleteChouffeur(Long id) {
        if (chouffeurRepository.existsById(id)) {
            chouffeurRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public List<Chouffeur> getAllChauffeurs() {
        return(  List<Chouffeur>) chouffeurRepository.findAll();
    }
}
