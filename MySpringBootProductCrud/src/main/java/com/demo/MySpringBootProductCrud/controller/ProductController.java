package com.demo.MySpringBootProductCrud.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.demo.MySpringBootProductCrud.beans.Product;
import com.demo.MySpringBootProductCrud.service.ProductService;

@RestController
public class ProductController {
   
	@Autowired
	private ProductService productService;
	
	
	
	@RequestMapping("/products")
	public ModelAndView displayproducts() {
		List<Product>plist=productService.getAllProducts();
		return new ModelAndView("displayproducts","plist",plist);
	}
	@RequestMapping("/addnewpro")
	public ModelAndView  addnewProduct(Model model) {
		Product p=new Product();
		model.addAttribute("product",p);
		return new ModelAndView("addproduct","msg","msg");	
	}
	
	@PostMapping("/insertproduct")
	public ModelAndView insertProduct(@Valid @ModelAttribute("product") Product p,BindingResult result)
	{
		if(result.hasErrors()) {
			return new ModelAndView("addproduct","msg","");
		}
		productService.addproduct(p);
		return new ModelAndView("redirect:/products");
		
	}
	@GetMapping("/edit/{prodid}")
	public ModelAndView editproduct(@PathVariable int prodid) {
		Product p=productService.getById(prodid);
		return new ModelAndView("editproduct","product",p);
	}
	 @PostMapping("/updateproduct")
	 public ModelAndView updateproduct(@ModelAttribute("product") Product p) {
		 productService.updateProduct(p);
		 return new ModelAndView("redirect:/products");
	 }
	 
	 @GetMapping("/delete/{prodid}")
	 public ModelAndView deleteById(@PathVariable int prodid) {
		 productService.deleteById(prodid);
		 return new ModelAndView("redirect:/products");
	 }
	 @GetMapping("/displaybyprice")
	 public ModelAndView displayByPrice() {
		 List<Product> plist=productService.sortByPrice();
		 return new ModelAndView("displaybyprice","plist",plist);
	 }
}
		


