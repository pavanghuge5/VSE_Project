package com.example.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;
import com.example.demo.entities.Company;
import com.example.demo.repositories.CompanyRepository;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class CompanyService {

    @Autowired
    private CompanyRepository companyRepository;

    // Create or update a company
    public Company saveCompany(Company company) {
        return companyRepository.save(company);
    }

    // Get all companies
    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    // Get a company by ID
    public Optional<Company> getCompanyById(int companyId) {
        return companyRepository.findById(companyId);
    }

    // Delete a company by ID
    public void deleteCompanyById(int companyId) {
        companyRepository.deleteById(companyId);
    }

    // Additional methods can be added as needed
}
