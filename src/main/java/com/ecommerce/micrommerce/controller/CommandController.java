package com.ecommerce.micrommerce.controller;

import com.ecommerce.micrommerce.dao.CommandDao;
import com.ecommerce.micrommerce.model.CommandModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/commandes")
public class CommandController {

    @Autowired
    private CommandDao commandDao;

    // READ - Récupérer toutes les commandes
    @GetMapping
    public List<CommandModel> listeCommandes() {
        return commandDao.findAll();
    }

    // READ - Récupérer une commande par son ID
    @GetMapping("/{id}")
    public ResponseEntity<CommandModel> afficherUneCommande(@PathVariable int id) {
        CommandModel command = commandDao.findById(id);
        if (command == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(command, HttpStatus.OK);
    }

    // CREATE - Ajouter une nouvelle commande
    @PostMapping
    public ResponseEntity<CommandModel> ajouterCommande(@RequestBody CommandModel command) {
        CommandModel nouvelleCommande = commandDao.save(command);
        return new ResponseEntity<>(nouvelleCommande, HttpStatus.CREATED);
    }

    // UPDATE - Mettre à jour une commande existante
    @PutMapping("/{id}")
    public ResponseEntity<CommandModel> modifierCommande(@PathVariable int id, @RequestBody CommandModel command) {
        CommandModel commandeExistante = commandDao.findById(id);
        if (commandeExistante == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        // Mise à jour des propriétés
        commandeExistante.setName(command.getName());
        commandeExistante.setPrice(command.getPrice());
        
        // Sauvegarde des modifications en utilisant la méthode save() du DAO
        CommandModel commandeMiseAJour = commandDao.save(commandeExistante);
        
        return new ResponseEntity<>(commandeMiseAJour, HttpStatus.OK);
    }

    // DELETE - Supprimer une commande
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerCommande(@PathVariable int id) {
        CommandModel commandeExistante = commandDao.findById(id);
        if (commandeExistante == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        // Suppression de la commande en utilisant la méthode delete du DAO
        commandDao.delete(id);
        
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}