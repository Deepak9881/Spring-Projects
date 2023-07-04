package com.demo.service;

import java.util.List;

import com.demo.beans.Product;

public interface ProductService {

	void addProduct();

	List<Product> displayAllProducts();

	boolean deleteById(int pid);

	boolean updateById(int pid, String pname, float price);

	Product displayById(int pid);

	List<Product> sortByPrice();

}
