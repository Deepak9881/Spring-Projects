package com.demo.dao;

import java.util.List;

import com.demo.beans.Product;

public interface ProductDao {


	List<Product> getAll();

	void addnewProduct(int prodid, String pname, int qty, float price);

	Product getById(int prodid);

	void updateProduct(int prodid, String pname, int qty, float price);

	void removeById(int prodid);




}
