package com.example.springmvc.dao;

import java.util.List;

import com.example.springmvc.model.Product;

public interface ProductServiceDao {

	List<Product> getAllProducts();

	Product getProdcutById(long id);

	int addProduct(Product Product);

	int updateProduct(Product Product);

	int deleteById(long id);

	Product getProductByName(String productname);
	
	List<Product> searchbrand(String name);

}
