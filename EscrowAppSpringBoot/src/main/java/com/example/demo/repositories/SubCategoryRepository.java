package com.example.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.SubCategory;
@Repository
@EnableJpaRepositories
public interface SubCategoryRepository extends JpaRepository<SubCategory, Integer> {
	
	 @Query("SELECT s FROM SubCategory s WHERE s.category.categoryId = :categoryId")
	List<SubCategory> findByCategoryId(int categoryId);
}
