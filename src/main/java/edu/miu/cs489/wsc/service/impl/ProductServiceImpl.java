package edu.miu.cs489.wsc.service.impl;

import edu.miu.cs489.wsc.model.Product;
import edu.miu.cs489.wsc.repository.ProductRepository;
import edu.miu.cs489.wsc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Product save(Product product) {
        return repository.save(product);
    }

    @Override
    public void delete(Product product) {
        repository.delete(product);
    }

    @Override
    public List<Product> getAllByCategory(Integer categoryId) {
        return repository.getProductsByCategory_CategoryId(categoryId);
    }

    @Override
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Product getOne(Integer id) {
        return repository.findById(id).orElse(null);
    }
}
