package com.ecommerce.micrommerce.dao;

import com.ecommerce.micrommerce.model.ProductModel;
import java.util.List;

public interface ProductDao {
    List<ProductModel> findAll();
    ProductModel findById(int id);
    ProductModel save(ProductModel product);
    void delete(int id);
}