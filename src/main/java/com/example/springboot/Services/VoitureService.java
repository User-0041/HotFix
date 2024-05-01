package com.example.springboot.Services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.Entitys.Voiture;
import com.example.springboot.Repositorys.VoitureRepository;

@Service
public class VoitureService<Vehicule> {

    @Autowired
    private static VoitureRepository VoitureRepository;

    // Méthode pour récupérer tous les véhicules
    public static List<Voiture> getAllVoiture() {
        return (List<Voiture>) VoitureRepository.findAll();
    }

    // Méthode pour récupérer un véhicule par son ID
    public Voiture getVoitureById(Long id) {
        Optional<Voiture> optionalVoiture = VoitureRepository.findById(id);
        return optionalVoiture.orElse(null);
    }

    // Méthode pour ajouter un nouveau véhicule
    public Voiture addVoiture(Voiture voiture) {
        return (Voiture) VoitureRepository.save(voiture);
    }

    // Méthode pour mettre à jour un véhicule existant

    public Voiture updateVoiture(Long id, Voiture newVoiture) {
        Optional<Voiture> optionalVoiture = VoitureRepository.findById(id);
        if (optionalVoiture.isPresent()) {
            Voiture existingVoiture = optionalVoiture.get(); // Retrieve Voiture object from Optional
    
            existingVoiture.setMarque(newVoiture.getMarque());
    
            return (com.example.springboot.Entitys.Voiture) VoitureRepository.save(existingVoiture);
        } else {
            return null;
        }
    }
    
    // Méthode pour supprimer un véhicule
    public boolean deleteVoiture(Long id) {
        Optional<Voiture> optionalVoiture = VoitureRepository.findById(id);
        if (optionalVoiture.isPresent()) {
            VoitureRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Vehicule getVehicleById(Long id) {

        throw new UnsupportedOperationException("Unimplemented method 'getVehicleById'");
    }

    @SuppressWarnings("rawtypes")
    public VoitureService createVehicle(VoitureService vehicle) {
        
        throw new UnsupportedOperationException("Unimplemented method 'createVehicle'");
    }

    public <Vehicle> Vehicle updateVehicle(Long id, Vehicle vehicle) {
        
        throw new UnsupportedOperationException("Unimplemented method 'updateVehicle'");
    }

    public boolean deleteVehicle(Long id) {
        throw new UnsupportedOperationException("Unimplemented method 'deleteVehicle'");
    }

    public static List<Voiture> getAllVoitures() {
       
        throw new UnsupportedOperationException("Unimplemented method 'getAllVoitures'");
    }

    @SuppressWarnings("hiding")
    public <Voiture> Voiture updateVoiture(Long id, Voiture voiture) {
        
        throw new UnsupportedOperationException("Unimplemented method 'updateVoiture'");
    }
}
