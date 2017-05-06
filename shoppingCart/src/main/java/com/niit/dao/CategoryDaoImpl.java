package com.niit.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.model.Category;

@Repository
@Transactional
public class CategoryDaoImpl implements CategoryDao {
	@Autowired
	private SessionFactory sessionFactory;
	

	public CategoryDaoImpl(SessionFactory sessionFactory) {
		super();
		this.sessionFactory = sessionFactory;

	}

	public List<Category> getCategories() {
		return sessionFactory.getCurrentSession().createQuery("from Category").list();
	}

	public Category getCategoryById(int id) {

		return null;
	}

}
