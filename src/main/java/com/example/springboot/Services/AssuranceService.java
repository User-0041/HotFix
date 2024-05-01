package com.example.springboot.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.Entitys.Assurance;
import com.example.springboot.Repositorys.AssuranceRepository;

@Service
public class AssuranceService<id> {

    @Autowired
    private AssuranceRepository assuranceRepository;

    // Méthode pour récupérer toutes les assurances
    public Iterable<Assurance> getAllAssurances() {
        return  assuranceRepository.findAll();
    }

    // Méthode pour récupérer une assurance par son ID
    public Assurance getAssuranceById(Long id ) {
        return assuranceRepository.findById(id).orElse(null);
    }

    // Méthode pour ajouter une nouvelle assurance
    public Assurance addAssurance(Assurance assurance) {
        return assuranceRepository.save(assurance);
    }

    // Méthode pour mettre à jour une assurance existante
    public Assurance updateAssurance(Long id, Assurance assurance) {
    
        if (assuranceRepository.existsById(id)) {
            ((Assurance) assurance).setId(id);
            return assuranceRepository.save(assurance);
        } else {
            return null;
        }
    }

    // Méthode pour supprimer une assurance
    public boolean deleteAssurance(Long id) {
        if (assuranceRepository.existsById(id)) {
            assuranceRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

 
}
