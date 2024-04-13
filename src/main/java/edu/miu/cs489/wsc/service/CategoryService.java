package edu.miu.cs489.wsc.service;

import edu.miu.cs489.wsc.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();
    Category save(Category category);
    void delete(Category category);
    Category findById(Integer id);
}
