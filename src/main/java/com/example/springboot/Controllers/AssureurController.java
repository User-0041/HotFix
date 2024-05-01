package com.example.springboot.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.springboot.Entitys.Assureur;
import com.example.springboot.Services.AssureurService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/assureurs")
public class AssureurController {

    @Autowired
    AssureurService assureurService;
    @GetMapping
    public List<Assureur> getAllAssureurs() {
        return assureurService.getAllAssureurs();
    }

    @GetMapping("/{id}")
    public Optional<Assureur> getAssureurById(@PathVariable Integer id) {
        return assureurService.getAssureurById(id);
    }

    @PostMapping
    public Assureur addAssureur(@RequestBody Assureur assureur) {
        return assureurService.addAssureur(assureur);
    }

    @PutMapping("/{id}")
    public Assureur updateAssureur(@PathVariable Integer id, @RequestBody Assureur assureur) {
        return assureurService.updateAssureur(id, assureur);
    }

    @DeleteMapping("/{id}")
    public void deleteAssureur(@PathVariable Integer id) {
        assureurService.deleteAssureur(id);
    }
}
