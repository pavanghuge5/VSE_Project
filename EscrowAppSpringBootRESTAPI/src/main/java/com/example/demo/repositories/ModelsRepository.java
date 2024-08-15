package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Models;
import java.util.List;

public interface ModelsRepository extends JpaRepository<Models, Integer> {
    List<Models> findByCompanyCompanyId(int companyId);
}