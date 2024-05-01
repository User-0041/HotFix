package com.example.springboot.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.springboot.Entitys.Chouffeur;
import com.example.springboot.Services.ChouffeurService;

import java.util.List;

@RestController
@RequestMapping("/api/chauffeur")
public class ChauffeurController {

    @Autowired
    private ChouffeurService chauffeurService;

    // Endpoint pour récupérer tous les chauffeurs
    @GetMapping
    public ResponseEntity<List<Chouffeur>> getAllChauffeurs() {
        List<Chouffeur> chauffeurs = chauffeurService.getAllChauffeurs();
        return new ResponseEntity<>(chauffeurs, HttpStatus.OK);
    }

    // Endpoint pour récupérer un chauffeur par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Chouffeur> getChauffeurById(@PathVariable("id") Long id) {
        Chouffeur chouffeur = chauffeurService.getChouffeurById(id);
        if (chouffeur != null) {
            return new ResponseEntity<>(chouffeur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour ajouter un nouveau chauffeur
    @PostMapping
    public ResponseEntity<Chouffeur> addChauffeur(@RequestBody Chouffeur chauffeur) {
        Chouffeur newChauffeur = chauffeurService.addChouffeur(chauffeur);
        return new ResponseEntity<>(newChauffeur, HttpStatus.CREATED);
    }

    // Endpoint pour mettre à jour un chauffeur existant
    @PutMapping("/{id}")
    public ResponseEntity<Chouffeur> updateChauffeur(@PathVariable("id") Long id, @RequestBody Chouffeur chauffeur) {
        Chouffeur updatedChauffeur = chauffeurService.updateChouffeur(id, chauffeur);
        if (updatedChauffeur != null) {
            return new ResponseEntity<>(updatedChauffeur, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Endpoint pour supprimer un chauffeur
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteChauffeur(@PathVariable("id") Long id) {
        boolean deleted = chauffeurService.deleteChouffeur(id);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
