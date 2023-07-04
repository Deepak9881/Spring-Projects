package com.demo.test;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.EmptyResultDataAccessException;

import com.demo.beans.Product;
import com.demo.service.ProductService;

public class TestProduct_Crud {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int choice=0;
		ApplicationContext ctx=new ClassPathXmlApplicationContext("Springconfig.xml");
		ProductService ps=(ProductService)ctx.getBean("productServiceImpl");
		do {
			System.out.println("1. add new Product\n 2. delete product by id\n 3. modify product\n");
			System.out.println("4. display all\n 5. display by id\n 6. sort by Price\n7. exit\n Choice :");
			choice=sc.nextInt();
			
			switch(choice) {
			case 1:
				ps.addProduct();
				break;
			case 2:
				System.out.println("Enter the product id");
				int pid=sc.nextInt();
				boolean status=ps.deleteById(pid);
				if(status)
					System.out.println("Product deleted successfully");
				else
					System.out.println("Product not found");
				break;
			case 3:	
				System.out.println("Enter the product id to be modified");
			    pid=sc.nextInt();
			    System.out.println("Enter the product name");
			    String pname=sc.next();
			    System.out.println("Enter the product price");
			    float price=sc.nextFloat();
			    status=ps.updateById(pid,pname,price);
			    if(status)
					System.out.println("Product deleted successfully");
				else
					System.out.println("Product not found");
				break;
			case 4:
				List<Product>plist=ps.displayAllProducts();
				plist.forEach(System.out::println);
				break;
			case 5:
				System.out.println("Enter the product id");
				pid=sc.nextInt();
				try {
				Product p=ps.displayById(pid);
				if(p!=null)
				System.out.println(p);
				else
					System.out.println("Invalid product");
				}catch(EmptyResultDataAccessException e) {
					System.out.println("Product not found");
				}
				break;
			case 6:
				plist=ps.sortByPrice();
				plist.forEach(System.out::println);
				break;
			case 7:
				((ClassPathXmlApplicationContext)ctx).close();
				break;
			default:
				System.out.println("Invalid login");
				
			}
		}while(choice!=7);
	}

}
