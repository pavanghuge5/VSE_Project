package com.example.demo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Models;
import com.example.demo.repositories.ModelsRepository;

@Service
public class ModelsService {

    @Autowired
    private ModelsRepository modelsRepository;

    public Models saveModel(Models model) {
        return modelsRepository.save(model);
    }

    public List<Models> getAllModels() {
        return modelsRepository.findAll();
    }

    public Optional<Models> getModelById(int modelId) {
        return modelsRepository.findById(modelId);
    }

    public List<Models> getModelsByCompanyId(int companyId) {
        return modelsRepository.findByCompanyCompanyId(companyId);
    }

    public void deleteModelById(int modelId) {
        modelsRepository.deleteById(modelId);
    }
}
