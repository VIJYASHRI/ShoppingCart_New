package com.niit.service;

import java.util.List;

import com.niit.model.Category;

public interface CategoryService {

	public List<Category> getCategories();

	public Category getCategoryById(int id);
}
