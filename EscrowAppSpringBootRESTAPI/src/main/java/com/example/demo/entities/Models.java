package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "model")
public class Models {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "model_id")
    private int modelId;

    @Column(name = "model_name", unique = true)
    private String modelName;

    @ManyToOne
    @JoinColumn(name = "com_id", nullable = false)
    @JsonIgnore
    private Company company;

    public Models() {
        super();
    }

    public Models(int modelId, String modelName, Company company) {
        this.modelId = modelId;
        this.modelName = modelName;
        this.company = company;
    }

    // Getters and Setters
    public int getModelId() {
        return modelId;
    }

    public void setModelId(int modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
