package edu.miu.cs489.wsc.service.impl;

import edu.miu.cs489.wsc.model.Category;
import edu.miu.cs489.wsc.repository.CategoryRepository;
import edu.miu.cs489.wsc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository repository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Category> getAll() {
        return repository.findAll();
    }

    @Override
    public Category add(Category category) {
        return repository.save(category);
    }
}
