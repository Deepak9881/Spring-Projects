package com.demo.service;

import java.util.List;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService{
@Autowired
private ProductDao productDao;




	public List<Product> displayAllProducts() {
		System.out.println("inside service");
		
		return  productDao.getAll();
	}




	public void addnewProduct(int prodid, String pname, int qty, float price) {
		productDao.addnewProduct(prodid,pname,qty,price);
		
	}




	public Product getById(int prodid) {
		
		return productDao.getById(prodid);
	}




	public void updateProduct(int prodid, String pname, int qty, float price) {
		productDao.updateProduct(prodid,pname,qty,price);
		
	}




	public void deleteById(int prodid) {
	   productDao.removeById(prodid);
	}



}
