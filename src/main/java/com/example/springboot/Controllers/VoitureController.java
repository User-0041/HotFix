package com.example.springboot.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.Services.VoitureService;

@RestController
@RequestMapping("/api/Voitures")
public class VoitureController<Voiture> {

    @SuppressWarnings("rawtypes")
    @Autowired
    private VoitureService VoitureService;

    // Endpoint pour récupérer tous les véhicules
    @SuppressWarnings({ "static-access", "unchecked" })
    @GetMapping
    public ResponseEntity<List<Voiture>> getAllVoitures() {
  
        List<Voiture> Voitures = (List<Voiture>) VoitureService.getAllVoiture();
        return new ResponseEntity<>(Voitures, HttpStatus.OK);
    }

    // Endpoint pour récupérer un véhicule par son ID
    @SuppressWarnings("unchecked")
    @GetMapping("/{id}")
    public ResponseEntity<Voiture> getVoitureById(@PathVariable("id") Long id) {
        Voiture Voiture = (Voiture) VoitureService.getVoitureById(id);
        if (Voiture != null) {
            return new ResponseEntity<>(Voiture, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour ajouter un nouveau véhicule
    @SuppressWarnings("unchecked")
    @PostMapping
    public ResponseEntity<Voiture> addVoiture(@RequestBody Voiture Voiture) {
        Voiture newVoiture = (Voiture) VoitureService.addVoiture((com.example.springboot.Entitys.Voiture) Voiture);
        return new ResponseEntity<>(newVoiture, HttpStatus.CREATED);
    }

    // Endpoint pour mettre à jour un véhicule existant
    @SuppressWarnings("unchecked")
    @PutMapping("/{id}")
    public ResponseEntity<Voiture> updateVoiture(@PathVariable("id") Long id, @RequestBody Voiture Voiture) {
        Voiture updatedVoiture = (Voiture) VoitureService.updateVoiture(id , Voiture);
        if (updatedVoiture != null) {
            return new ResponseEntity<>(updatedVoiture, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour supprimer un véhicule
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVoiture(@PathVariable("id") Long id) {
        boolean deleted = VoitureService.deleteVoiture(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
