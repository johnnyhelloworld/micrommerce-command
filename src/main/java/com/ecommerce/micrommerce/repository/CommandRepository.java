package com.ecommerce.micrommerce.repository;

import com.ecommerce.micrommerce.model.CommandModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CommandRepository extends JpaRepository<CommandModel, Integer> {
    // Spring Data JPA génère automatiquement les méthodes CRUD de base
    // Vous pouvez ajouter des méthodes personnalisées ici si nécessaire
}