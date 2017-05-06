package com.niit.service;


import java.util.List;

import com.niit.model.Product;

public interface ProductService {
	public void saveProduct(Product product);
	public Product getProductById(int id);
	public Product updateProduct(Product product);
	public void deleteProduct(Product product);
	public List<Product> getAllProduct();
}
