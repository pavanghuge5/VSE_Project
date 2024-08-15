package com.example.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Model;
import com.example.demo.services.ModelService;

@RestController
@RequestMapping("/models")
public class ModelController {

    @Autowired
    private ModelService modelService;

    // Create a new model
    @PostMapping
    public Model createModel(@RequestBody Model model) {
        return modelService.saveModel(model);
    }

    // Get all models
    @GetMapping
    public List<Model> getAllModels() {
        return modelService.getAllModels();
    }

    // Get a model by ID
    @GetMapping("/{id}")
    public Model getModelById(@PathVariable("id") int modelId) {
        return modelService.getModelById(modelId).orElse(null);
    }

    // Get models by company ID
//    @GetMapping("/company/{companyId}")
//    public List<Model> getModelsByCompanyId(@PathVariable("companyId") int companyId) {
//        return modelService.getModelsByCompanyId(companyId);
//    }

    // Update an existing model
    @PutMapping("/{id}")
    public Model updateModel(@PathVariable("id") int modelId, @RequestBody Model modelDetails) {
        Optional<Model> model = modelService.getModelById(modelId);

        if (model.isPresent()) {
            Model updatedModel = model.get();
            updatedModel.setModelName(modelDetails.getModelName());
            updatedModel.setCompany(modelDetails.getCompany());

            return modelService.saveModel(updatedModel);
        } else {
            return null; // Handle this case more gracefully in production
        }
    }

    // Delete a model by ID
    @DeleteMapping("/{id}")
    public void deleteModel(@PathVariable("id") int modelId) {
        modelService.deleteModelById(modelId);
    }
}
