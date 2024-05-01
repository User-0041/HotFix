package com.example.springboot.Services;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.springboot.Entitys.Voiture;
import com.example.springboot.Repositorys.VoitureRepository;

@Service
public class VoitureService {

    @Autowired
     VoitureRepository voitureRepository;
    // Méthode pour récupérer tous les véhicules
    public  List<Voiture> getAllVoiture() {
        return (List<Voiture>)  voitureRepository.findAll();
    }

    // Méthode pour récupérer un véhicule par son ID
    public Voiture getVoitureById(Long id) {
        Optional<Voiture> optionalVoiture = voitureRepository.findById(id);
        return optionalVoiture.orElse(null);
    }

    // Méthode pour ajouter un nouveau véhicule
    public Voiture addVoiture(Voiture voiture) {
        return (Voiture) voitureRepository.save(voiture);
    }

    // Méthode pour mettre à jour un véhicule existant

    public Voiture updateVoiture(Long id, Voiture newVoiture) {
        Optional<Voiture> optionalVoiture = voitureRepository.findById(id);
        if (optionalVoiture.isPresent()) {
            Voiture existingVoiture = optionalVoiture.get(); // Retrieve Voiture object from Optional
    
            existingVoiture.setMarque(newVoiture.getMarque());
    
            return (com.example.springboot.Entitys.Voiture) voitureRepository.save(existingVoiture);
        } else {
            return null;
        }
    }
    
    // Méthode pour supprimer un véhicule
    public boolean deleteVoiture(Long id) {
        Optional<Voiture> optionalVoiture = voitureRepository.findById(id);
        if (optionalVoiture.isPresent()) {
            voitureRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

   


   
}
