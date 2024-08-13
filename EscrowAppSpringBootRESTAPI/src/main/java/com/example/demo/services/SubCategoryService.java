package com.example.demo.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.repositories.SubCategoryRepository;

import jakarta.transaction.Transactional;
@Service
@Transactional
public class SubCategoryService {
    @Autowired
    private SubCategoryRepository subCategoryRepository;

 
}
