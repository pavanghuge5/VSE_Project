package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.SubCategory;
@Repository
public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {

}
