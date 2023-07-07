package com.demo.MySpringBootProductCrud.service;

import java.util.List;

import javax.validation.Valid;

import com.demo.MySpringBootProductCrud.beans.Product;

public interface ProductService {

	List<Product> getAllProducts();

	void addproduct(@Valid Product p);

	Product getById(int pid);

	void updateProduct(Product p);

	void deleteById(int prodid);

	List<Product> sortByPrice();

}
