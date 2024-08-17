package com.example.demo.services;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.SubCategory;
import com.example.demo.repositories.SubCategoryRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class SubCategoryService {
    @Autowired
    private SubCategoryRepository subCategoryRepository;
    
    public List<SubCategory> getAllSubCategories() {
        return subCategoryRepository.findAll();
    }
    
    //Get Sub Category by id
    public Optional<SubCategory> getSubCategoryById(int id) {
        return subCategoryRepository.findById(id);
    }

    //Get Sub Categories by Category Id
    public List<SubCategory> getSubCategoriesByCategoryId(int categoryId) {
        return subCategoryRepository.findByCategoryId(categoryId);
    }

    public SubCategory saveSubCategory(SubCategory subCategory) {
        return subCategoryRepository.save(subCategory);
    }

    public void deleteSubCategory(int id) {
        subCategoryRepository.deleteById(id);
    }
    
    
 
}
