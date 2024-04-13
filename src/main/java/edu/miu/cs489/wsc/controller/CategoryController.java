package edu.miu.cs489.wsc.controller;

import edu.miu.cs489.wsc.model.Category;
import edu.miu.cs489.wsc.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryService service;

    @Autowired
    public CategoryController(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<Category>> getCategories() {
        return ResponseEntity.ok(service.getAll());
    }

    @PostMapping
    public ResponseEntity<Category> addCategory(@RequestBody Category category) {
        Category addedCategory = service.save(category);
        return ResponseEntity.ok(addedCategory);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateCategory(@PathVariable Integer id, @RequestBody Category category) {
        Category findCategory = service.findById(id);
        if (findCategory == null) {
            return new ResponseEntity<>("Category not found!", HttpStatus.NOT_FOUND);
        }
        category.setCategoryId(id);
        service.save(category);
        return ResponseEntity.ok("Updated successfully!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCategory(@PathVariable Integer id) {
        Category findCategory = service.findById(id);
        if (findCategory == null) {
            return new ResponseEntity<>("Category not found!", HttpStatus.NOT_FOUND);
        }
        service.delete(findCategory);
        return ResponseEntity.ok("Deleted successfully!");
    }

}
