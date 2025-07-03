package com.ecommerce.micrommerce.dao;

import com.ecommerce.micrommerce.model.ProductModel;
import com.ecommerce.micrommerce.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements ProductDao {
    
    @Autowired
    private ProductRepository productRepository;
    
    // Méthode pour initialiser des données de test si nécessaire
    // Cette méthode peut être appelée au démarrage de l'application
    public void initData() {
        if (productRepository.count() == 0) {
            productRepository.save(new ProductModel(0, "Ordinateur portable", 150));
            productRepository.save(new ProductModel(0, "Aspirateur Robot", 500));
            productRepository.save(new ProductModel(0, "Table de ping pong", 750));
        }
    }

    @Override
    public List<ProductModel> findAll() {
        return productRepository.findAll();
    }

    @Override
    public ProductModel findById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public ProductModel save(ProductModel product) {
        return productRepository.save(product);
    }
    
    @Override
    public void delete(int id) {
        productRepository.deleteById(id);
    }
}