package com.ecommerce.micrommerce.controller;

import com.ecommerce.micrommerce.dao.ProductDao;
import com.ecommerce.micrommerce.model.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produits")
public class ProductController {

    @Autowired
    private ProductDao productDao;

    // READ - Récupérer tous les produits
    @GetMapping
    public List<ProductModel> listeProduits() {
        return productDao.findAll();
    }

    // READ - Récupérer un produit par son ID
    @GetMapping("/{id}")
    public ResponseEntity<ProductModel> afficherUnProduit(@PathVariable int id) {
        ProductModel product = productDao.findById(id);
        if (product == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    // CREATE - Ajouter un nouveau produit
    @PostMapping
    public ResponseEntity<ProductModel> ajouterProduit(@RequestBody ProductModel product) {
        ProductModel nouveauProduit = productDao.save(product);
        return new ResponseEntity<>(nouveauProduit, HttpStatus.CREATED);
    }

    // UPDATE - Mettre à jour un produit existant
    @PutMapping("/{id}")
    public ResponseEntity<ProductModel> modifierProduit(@PathVariable int id, @RequestBody ProductModel product) {
        ProductModel produitExistant = productDao.findById(id);
        if (produitExistant == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        // Mise à jour des propriétés
        produitExistant.setName(product.getName());
        produitExistant.setPrice(product.getPrice());
        
        // Comme nous n'avons pas de méthode update dans le DAO, nous simulons une mise à jour
        // Dans un cas réel, il faudrait implémenter une méthode update dans le DAO
        return new ResponseEntity<>(produitExistant, HttpStatus.OK);
    }

    // DELETE - Supprimer un produit
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimerProduit(@PathVariable int id) {
        ProductModel produitExistant = productDao.findById(id);
        if (produitExistant == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        // Comme nous n'avons pas de méthode delete dans le DAO, nous simulons une suppression
        // Dans un cas réel, il faudrait implémenter une méthode delete dans le DAO
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}