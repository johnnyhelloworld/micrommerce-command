package com.ecommerce.micrommerce.repository;

import com.ecommerce.micrommerce.model.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel, Integer> {
    // Spring Data JPA génère automatiquement les méthodes CRUD de base
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
}