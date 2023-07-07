package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	List<Product> displayAllProducts();



	void addnewProduct(int prodid, String pname, int qty, float price);

	Product getById(int prodid);

	void updateProduct(int prodid, String pname, int qty, float price);

    void deleteById(int prodid);

	
}
