package com.example.demo.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cat_id")
    private int categoryId;

    @Column(name = "cat_name")
    private String categoryName;
    
    
    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<SubCategory> subcategories;


	public Category() {
		super();
	}


	public Category(int categoryId, String categoryName, List<SubCategory> subcategories) {
		super();
		this.categoryId = categoryId;
		this.categoryName = categoryName;
		this.subcategories = subcategories;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


	public List<SubCategory> getSubcategories() {
		return subcategories;
	}


	public void setSubcategories(List<SubCategory> subcategories) {
		this.subcategories = subcategories;
	}

    
}
