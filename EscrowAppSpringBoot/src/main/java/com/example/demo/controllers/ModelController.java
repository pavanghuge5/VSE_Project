package com.example.demo.controllers;

import com.example.demo.entities.Model;
import com.example.demo.services.ModelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/models")
public class ModelController {

    @Autowired
    private ModelService modelService;

    @GetMapping
    public List<Model> getAllModels() {
        return modelService.getAllModels();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Model> getModelById(@PathVariable int id) {
        Optional<Model> model = modelService.getModelById(id);
        return model.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Model createModel(@RequestBody Model model) {
        return modelService.saveModel(model);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Model> updateModel(@PathVariable int id, @RequestBody Model modelDetails) {
        Optional<Model> model = modelService.getModelById(id);
        if (model.isPresent()) {
            Model updatedModel = model.get();
            updatedModel.setModelName(modelDetails.getModelName());
            updatedModel.setCompany(modelDetails.getCompany());
            return ResponseEntity.ok(modelService.saveModel(updatedModel));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteModel(@PathVariable int id) {
        modelService.deleteModel(id);
        return ResponseEntity.noContent().build();
    }
}