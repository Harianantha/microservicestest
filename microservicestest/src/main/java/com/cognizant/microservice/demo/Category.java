package com.cognizant.microservice.demo;

import java.util.ArrayList;
import java.util.List;

public class Category {

    private final long id;
    private final String categoryName;
    private final List<Category> childCategories=new ArrayList<Category>();
    private final List<Product> products=new ArrayList<Product>();
    

    public long getId() {
		return id;
	}


	public String getCategoryName() {
		return categoryName;
	}


	public List<Category> getChildCategories() {
		return childCategories;
	}


	public List<Product> getProducts() {
		return products;
	}


	public Category(long id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

  
}
