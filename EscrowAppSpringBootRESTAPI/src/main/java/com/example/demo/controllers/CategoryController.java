package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.CategoryService;

@RestController
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

}
