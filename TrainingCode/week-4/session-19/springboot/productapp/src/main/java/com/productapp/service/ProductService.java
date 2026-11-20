package com.productapp.service;

import com.productapp.entities.Product;

import java.util.List;

public interface ProductService {
    public List<Product> findAll();
    public Product addProduct(Product product);
    public Product updateProduct(int id, Product product);
    public Product getById(int id);
    public Product deleteById(int id);
}
