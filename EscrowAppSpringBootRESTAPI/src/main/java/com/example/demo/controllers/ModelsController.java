package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Models;
import com.example.demo.services.ModelsService;

@RestController
@RequestMapping("/models")
public class ModelsController {

    @Autowired
    private ModelsService modelsService;

    // Create a new model
    @PostMapping
    public Models createModel(@RequestBody Models model) {
        return modelsService.saveModel(model);
    }

    // Get all models
    @GetMapping
    public List<Models> getAllModels() {
        return modelsService.getAllModels();
    }

    // Get a model by ID
    @GetMapping("/{id}")
    public Models getModelById(@PathVariable("id") int modelId) {
        return modelsService.getModelById(modelId).orElse(null);
    }

    // Get models by company ID
    @GetMapping("/company/{companyId}")
    public List<Models> getModelsByCompanyId(@PathVariable("companyId") int companyId) {
        return modelsService.getModelsByCompanyId(companyId);
    }

    // Update an existing model
    @PutMapping("/{id}")
    public Models updateModel(@PathVariable("id") int modelId, @RequestBody Models modelDetails) {
        Optional<Models> model = modelsService.getModelById(modelId);

        if (model.isPresent()) {
            Models updatedModel = model.get();
            updatedModel.setModelName(modelDetails.getModelName());
            updatedModel.setCompany(modelDetails.getCompany());

            return modelsService.saveModel(updatedModel);
        } else {
            return null; // Handle this case more gracefully in production
        }
    }

    // Delete a model by ID
    @DeleteMapping("/{id}")
    public void deleteModel(@PathVariable("id") int modelId) {
        modelsService.deleteModelById(modelId);
    }
}
