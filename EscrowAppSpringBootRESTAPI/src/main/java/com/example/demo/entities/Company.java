package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "com_id")
    private int companyId;

    @Column(name = "com_name")
    private String companyName;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Models> models;

    public Company() {
        super();
    }

    public Company(int companyId, String companyName, List<Models> models) {
        this.companyId = companyId;
        this.companyName = companyName;
        this.models = models;
    }

    // Getters and Setters
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public List<Models> getModels() {
        return models;
    }

    public void setModels(List<Models> models) {
        this.models = models;
    }
}
