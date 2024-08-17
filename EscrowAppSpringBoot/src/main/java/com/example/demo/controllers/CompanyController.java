package com.example.demo.controllers;

import com.example.demo.entities.Company;
import com.example.demo.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public List<Company> getAllCompanies() {
        return companyService.getAllCompanies();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable int id) {
        Optional<Company> company = companyService.getCompanyById(id);
        return company.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Company createCompany(@RequestBody Company company) {
        return companyService.saveCompany(company);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Company> updateCompany(@PathVariable int id, @RequestBody Company companyDetails) {
        Optional<Company> company = companyService.getCompanyById(id);
        if (company.isPresent()) {
            Company updatedCompany = company.get();
            updatedCompany.setCompanyName(companyDetails.getCompanyName());
            updatedCompany.setModels(companyDetails.getModels());
            return ResponseEntity.ok(companyService.saveCompany(updatedCompany));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable int id) {
        companyService.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }
}