package com.demo.MySpringBootProductCrud.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.MySpringBootProductCrud.beans.Product;
import com.demo.MySpringBootProductCrud.dao.ProductDao;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductDao productDao;

	@Override
	public List<Product> getAllProducts() {
		List<Product>plist=productDao.findAll();
		System.out.println(plist);
		return plist;
	}

	@Override
	public void addproduct(Product p) {
		productDao.save(p);
	}

	@Override
	public Product getById(int prodid) {
		return productDao.getById(prodid);
	}

	@Override
	public void updateProduct(Product p) {
		Optional<Product> op=productDao.findById(p.getProdid());
		if(op.isPresent()) {
			Product pr=op.get();
		pr.setPname(p.getPname());
		pr.setQuantity(p.getQuantity());
		pr.setPrice(p.getPrice());
		productDao.save(pr);
		}
	}

	@Override
	public void deleteById(int prodid) {
	 productDao.deleteById(prodid);
		
	}

	@Override
	public List<Product> sortByPrice() {
		return productDao.sortByPrice();
	}
	
}
