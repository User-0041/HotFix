package com.example.springboot.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot.Entitys.Assurance;
import com.example.springboot.Services.AssuranceService;

@RestController
@RequestMapping("/assurances")
public class AssuranceController {
@SuppressWarnings("rawtypes")
@Autowired
AssuranceService assuranceService;
    @GetMapping("/{id}")
    public Assurance getAssuranceById(@PathVariable Long id) {
        // Code pour récupérer une assurance par son ID depuis la base de données
        return assuranceService.getAssuranceById(id);
    }

    @PostMapping
    public Assurance createAssurance(@RequestBody Assurance assurance) {
        // Code pour créer une nouvelle assurance dans la base de données
        return assuranceService.addAssurance(assurance);
    }

    @PutMapping("/{id}")
    public Assurance updateAssurance(@PathVariable Long id, @RequestBody Assurance assuranceDetails) {
        // Code pour mettre à jour une assurance existante dans la base de données
        return assuranceService.updateAssurance(id, assuranceDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAssurance(@PathVariable Long id) {
        // Code pour supprimer une assurance de la base de données
        assuranceService.deleteAssurance(id);
        return ResponseEntity.ok().build();
    }
}
