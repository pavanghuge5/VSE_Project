package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.SubCategory;
import com.example.demo.services.SubCategoryService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/subcategories")
public class SubCategoryController {

    @Autowired
    private SubCategoryService subCategoryService;

    // Get all sub categories
    @GetMapping
    public List<SubCategory> getAllSubCategories() {
        return subCategoryService.getAllSubCategories();
    }

    // Get sub category by ID
    @GetMapping("/{id}")
    public SubCategory getSubCategoryById(@PathVariable int id) {
        return subCategoryService.getSubCategoryById(id)
                .orElse(null);  // Returns null if not found
    }

    // Get sub categories by category ID
    @GetMapping("/category/{categoryId}")
    public List<SubCategory> getSubCategoriesByCategoryId(@PathVariable int categoryId) {
        return subCategoryService.getSubCategoriesByCategoryId(categoryId);
    }

    // Create or update a sub category
    @PostMapping
    public SubCategory saveSubCategory(@RequestBody SubCategory subCategory) {
        return subCategoryService.saveSubCategory(subCategory);
    }

    // Delete a sub category by ID
    @DeleteMapping("/{id}")
    public void deleteSubCategory(@PathVariable int id) {
        subCategoryService.deleteSubCategory(id);
    }
}
