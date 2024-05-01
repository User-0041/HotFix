package com.example.springboot.Services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springboot.Entitys.User;
import com.example.springboot.Repositorys.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Méthode pour récupérer tous les utilisateurs
    public List<User> getAllUsers() {
        return (List<User>) userRepository.findAll();
    }

    // Méthode pour récupérer un utilisateur par son ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
            
    }

    // Méthode pour créer un nouvel utilisateur
    public User createUser(User user) {
        // Ajoutez ici la logique pour valider les données de l'utilisateur, par exemple, vérifier les champs obligatoires
        return userRepository.save(user);
    }

    // Méthode pour mettre à jour un utilisateur existant
    public User updateUser(Long id, User user) {
        // Vérifie si l'utilisateur existe
        if (!userRepository.existsById(id)) {
            return null; 
        }
        // Met à jour l'utilisateur avec les nouvelles données
        user.setId(id);
        return userRepository.save(user);
    }

    // Méthode pour supprimer un utilisateur
    public void deleteUser(Long id) {
        // Vérifie si l'utilisateur existe
        if (!userRepository.existsById(id)) {
            return  ;
        }
        // Supprime l'utilisateur
        userRepository.deleteById(id);
    }
}
