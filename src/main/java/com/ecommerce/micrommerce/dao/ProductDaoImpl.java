package com.ecommerce.micrommerce.dao;

import com.ecommerce.micrommerce.model.ProductModel;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDaoImpl implements ProductDao {
    public static List<ProductModel> products = new ArrayList<>();

    static {
        products.add(new ProductModel(1, "Ordinateur portable", 150));
        products.add(new ProductModel(2, "Aspirateur Robot", 500));
        products.add(new ProductModel(3, "Table de ping pong", 750));
    }

    @Override
    public List<ProductModel> findAll() {
        return products;
    }

    @Override
    public ProductModel findById(int id) {
        for (ProductModel product : products) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public ProductModel save(ProductModel product) {
        products.add(product);
        return product;
    }
}