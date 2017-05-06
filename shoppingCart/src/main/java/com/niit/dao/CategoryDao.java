package com.niit.dao;

import java.util.List;

import com.niit.model.Category;

public interface CategoryDao {
	List<Category> getCategories();

	Category getCategoryById(int id);
}
