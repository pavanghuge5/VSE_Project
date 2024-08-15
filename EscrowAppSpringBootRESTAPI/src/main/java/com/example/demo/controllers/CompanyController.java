package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Company;
import com.example.demo.services.CompanyService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    // Create a new company
    @PostMapping
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        Company savedCompany = companyService.saveCompany(company);
        return ResponseEntity.ok(savedCompany);
    }

    // Get all companies
    @GetMapping
    public ResponseEntity<List<Company>> getAllCompanies() {
        List<Company> companies = companyService.getAllCompanies();
        return ResponseEntity.ok(companies);
    }

    // Get a company by ID
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable("id") int id) {
        Optional<Company> company = companyService.getCompanyById(id);
        return company.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update an existing company
    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable("id") int id, @RequestBody Company company) {
        company.setCompanyId(id);
        Company updatedCompany = companyService.saveCompany(company);
        return ResponseEntity.ok(updatedCompany);
    }

    // Delete a company by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompanyById(@PathVariable("id") int id) {
        companyService.deleteCompanyById(id);
        return ResponseEntity.noContent().build();
    }
}
