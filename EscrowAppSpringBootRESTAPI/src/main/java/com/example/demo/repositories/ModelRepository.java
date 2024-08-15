package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Model;
import java.util.List;

public interface ModelRepository extends JpaRepository<Model, Integer> {
    List<Model> findByCompanyCompanyId(int companyId);
}