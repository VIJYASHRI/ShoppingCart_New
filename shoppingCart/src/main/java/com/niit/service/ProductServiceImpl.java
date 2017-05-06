package com.niit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.niit.dao.ProductDao;
import com.niit.model.Product;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {
	@Autowired
	private ProductDao productDao;
	public ProductServiceImpl(){
		System.out.println("ProductServiceImpl created");
	}

	public void saveProduct(Product product) {
		productDao.saveProduct(product);
	}

	public Product getProductById(int id) {
		return (Product)productDao.getProductById(id); 
	}

	public Product updateProduct(Product product) {
		System.out.println("Update in prd service");
		Product p = productDao.updateProduct(product);
		
		return p;

	}

	public void deleteProduct(Product product) {
		productDao.deleteProduct(product);
	}

	public List<Product> getAllProduct() {

		return productDao.getAllProduct();
	}

}	
