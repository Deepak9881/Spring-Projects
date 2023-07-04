package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.demo.beans.Product;
import com.demo.service.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@RequestMapping("/displayproduct")
	public ModelAndView displayProduct() {
		List<Product>plist=productService.displayAllProducts();
		return new ModelAndView("displayproduct","plist",plist);
	}
	@RequestMapping("/addnewproduct")
    public String addProduct() {
    	return "addproduct";
    }
	@PostMapping("/addproduct")
	public ModelAndView addnewProduct(@RequestParam int prodid,@RequestParam String pname,@RequestParam int qty,@RequestParam float price) {
		productService.addnewProduct(prodid,pname,qty,price);
		return new ModelAndView("redirect:/product/displayproduct");
	}
	
	@RequestMapping("/edit/{pid}")
	public ModelAndView editProduct(@PathVariable("pid") int prodid) {
		System.out.println(prodid);
		Product p=productService.getById(prodid);
		return new ModelAndView("editproduct","p",p);
	}
	
	@PostMapping("/updateproduct")
	public ModelAndView updateproduct(@RequestParam int prodid,@RequestParam String pname,@RequestParam int qty,@RequestParam float price) {
		
	    productService.updateProduct(prodid,pname,qty,price);
	    return new ModelAndView("redirect:/product/displayproduct");
	}
	
	@RequestMapping("/delete/{pid}")
	public ModelAndView deleteProduct(@PathVariable("pid") int prodid) {
		System.out.println(prodid);
		productService.deleteById(prodid);
		return new ModelAndView("redirect:/product/displayproduct");
	}
	
  
}
