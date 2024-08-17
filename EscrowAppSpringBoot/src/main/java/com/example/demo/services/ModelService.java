package com.example.demo.services;

import com.example.demo.entities.Model;
import com.example.demo.repositories.ModelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ModelService {

    @Autowired
    private ModelRepository modelRepository;

    public List<Model> getAllModels() {
        return modelRepository.findAll();
    }

    public Optional<Model> getModelById(int id) {
        return modelRepository.findById(id);
    }

    public Model saveModel(Model model) {
        return modelRepository.save(model);
    }

    public void deleteModel(int id) {
        modelRepository.deleteById(id);
    }
}