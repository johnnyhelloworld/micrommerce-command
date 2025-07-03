package com.ecommerce.micrommerce.dao;

import com.ecommerce.micrommerce.model.CommandModel;
import com.ecommerce.micrommerce.repository.CommandRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CommandDaoImpl implements CommandDao {
    
    @Autowired
    private CommandRepository commandRepository;
    
    // Méthode pour initialiser des données de test si nécessaire
    // Cette méthode peut être appelée au démarrage de l'application
    public void initData() {
        if (commandRepository.count() == 0) {
            commandRepository.save(new CommandModel(0, "Ordinateur portable", 150));
            commandRepository.save(new CommandModel(0, "Aspirateur Robot", 500));
            commandRepository.save(new CommandModel(0, "Table de ping pong", 750));
        }
    }

    @Override
    public List<CommandModel> findAll() {
        return commandRepository.findAll();
    }

    @Override
    public CommandModel findById(int id) {
        return commandRepository.findById(id).orElse(null);
    }

    @Override
    public CommandModel save(CommandModel command) {
        return commandRepository.save(command);
    }
    
    @Override
    public void delete(int id) {
        commandRepository.deleteById(id);
    }
}