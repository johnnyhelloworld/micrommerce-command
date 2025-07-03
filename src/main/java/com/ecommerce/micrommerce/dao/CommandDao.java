package com.ecommerce.micrommerce.dao;

import com.ecommerce.micrommerce.model.CommandModel;
import java.util.List;

public interface CommandDao {
    List<CommandModel> findAll();
    CommandModel findById(int id);
    CommandModel save(CommandModel command);
    void delete(int id);
}