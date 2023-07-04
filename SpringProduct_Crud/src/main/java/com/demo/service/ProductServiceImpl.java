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

	public void addProduct() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the product id");
		int id=sc.nextInt();
		System.out.println("Enter the product name");
		String pname=sc.next();
		System.out.println("Enter the product Qty");
		int qty=sc.nextInt();
		System.out.println("Enter the product price");
		float price=sc.nextFloat();
		Product p=new Product(id,pname,qty,price);
		productDao.save(p);
	
	}

	@Override
	public List<Product> displayAllProducts() {
		
		return  productDao.getAll();
	}

	@Override
	public boolean deleteById(int pid) {
		return productDao.removeById(pid);
	}

	@Override
	public boolean updateById(int pid, String pname, float price) {
		return productDao.modifyById(pid,pname,price);
	}

	@Override
	public Product displayById(int pid) {
		return productDao.getById(pid);
	}

	@Override
	public List<Product> sortByPrice() {
		return productDao.sortByPrice();
	}



}
