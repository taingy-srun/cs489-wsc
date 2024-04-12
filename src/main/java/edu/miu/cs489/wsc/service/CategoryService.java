package edu.miu.cs489.wsc.service;

import edu.miu.cs489.wsc.model.Category;

import java.util.List;

public interface CategoryService {

    List<Category> getAll();
    Category add(Category category);
}
