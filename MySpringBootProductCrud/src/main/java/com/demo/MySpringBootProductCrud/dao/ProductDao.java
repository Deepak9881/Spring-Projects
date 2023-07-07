package com.demo.MySpringBootProductCrud.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.demo.MySpringBootProductCrud.beans.Product;

public interface ProductDao extends JpaRepository<Product, Integer>{
	
	@Query("select p from Product p order by price")
	public List<Product> sortByPrice();

}
