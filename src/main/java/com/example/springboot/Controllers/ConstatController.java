package com.example.springboot.Controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springboot.Entitys.Constat;
import com.example.springboot.Services.ConstatService;

import java.util.List;

@RestController
@RequestMapping("/constat")



public class ConstatController {
    @Autowired
    
    private final ConstatService constatService;

    public ConstatController(ConstatService constatService) {
        this.constatService = constatService;
    }

    // Endpoint pour récupérer tous les constats
    @GetMapping
    public ResponseEntity<List<Constat>> getAllConstats() {
        List<Constat> constats = constatService.getAllConstats();
        return new ResponseEntity<>(constats, HttpStatus.OK);
    }

    // Endpoint pour récupérer un constat par son ID
    @GetMapping("/{id}")
    public ResponseEntity<Constat> getConstatById(@PathVariable Integer id) {
        Constat constat = constatService.getConstatById(id);
        return new ResponseEntity<>(constat, HttpStatus.OK);
    }

    // Endpoint pour créer un nouveau constat
    @PostMapping
    public ResponseEntity<Constat> createConstat(@RequestBody Constat constat) {
        Constat createdConstat = constatService.createConstat(constat);
        return new ResponseEntity<>(createdConstat, HttpStatus.CREATED);
    }

    // Endpoint pour mettre à jour un constat existant
    @PutMapping("/{id}")
    public ResponseEntity<Constat> updateConstat(@PathVariable Integer id, @RequestBody Constat constat) {
        Constat updatedConstat = constatService.updateConstat(id, constat);
        return new ResponseEntity<>(updatedConstat, HttpStatus.OK);
    }

    // Endpoint pour supprimer un constat par son ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteConstat(@PathVariable Integer id) {
        constatService.deleteConstat(id);
        return ResponseEntity.ok().build();
    }
}
