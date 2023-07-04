package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {

	void save(Product p);

	List<Product> getAll();

	boolean removeById(int pid);

	boolean modifyById(int pid, String pname, float price);

	Product getById(int pid);

	List<Product> sortByPrice();

}
