package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "sub_category")
public class SubCategory {


	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subcat_id")
    private int subCategoryId;

    @Column(name = "subcat_name")
    private String subCategoryName;

    @ManyToOne
    @JoinColumn(name = "cat_id", nullable = false)
    @JsonIgnore
    private Category category;
    
    
    public SubCategory() {
		super();
    }    

	public SubCategory(int subCategoryId, String subCategoryName, Category category) {
		super();
		this.subCategoryId = subCategoryId;
		this.subCategoryName = subCategoryName;
		this.category = category;
	}





	public int getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

    
}
