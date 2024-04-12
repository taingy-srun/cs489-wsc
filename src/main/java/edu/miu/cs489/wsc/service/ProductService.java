package edu.miu.cs489.wsc.service;

import edu.miu.cs489.wsc.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getAll();
    Product getOne(Integer id);
    Product save(Product product);
    void delete(Product product);
    List<Product> getAllByCategory(Integer categoryId);
}
