package com.ecommerce.micrommerce.config;

import com.ecommerce.micrommerce.dao.CommandDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataInitializer {

    @Autowired
    private CommandDaoImpl commandDaoImpl;

    @Bean
    public CommandLineRunner initializeData() {
        return args -> {
            // Initialisation des données au démarrage
            commandDaoImpl.initData();
            System.out.println("Données initialisées avec succès!");
        };
    }
}