package com.example.demo.services;

import com.example.demo.entities.Category;
import com.example.demo.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CategoryService {
    
    @Autowired
    private CategoryRepository categoryRepository;

    // Method to retrieve all categories
    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    // Method to get a category by ID
    public Category getCategoryById(int id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElse(null);
    }

    // Method to create a new category
    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    // Method to update an existing category
    public Category updateCategory(int id, Category updatedCategory) {
        Category category = getCategoryById(id);
        if (category != null) {
            category.setCategoryName(updatedCategory.getCategoryName());
            category.setSubcategories(updatedCategory.getSubcategories());
            return categoryRepository.save(category);
        }
        return null;
    }

    // Method to delete a category
    public void deleteCategory(int id) {
        categoryRepository.deleteById(id);
    }
}
