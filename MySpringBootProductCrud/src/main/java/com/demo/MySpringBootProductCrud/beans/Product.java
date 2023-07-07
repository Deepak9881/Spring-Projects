package com.demo.MySpringBootProductCrud.beans;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name="productss")
public class Product{
@Id
private int prodid;
@NotBlank(message="Name cannot be blank")
@Size(min=4 ,max=12,message="Should contain min 4 and max 12 characters")
private String pname;
@Min(value=10)
@Max(value=40)
private int quantity;
private float price;


public Product() {
	super();
}


public Product(int pid, String pname, int qty, float price) {
	super();
	this.prodid = pid;
	this.pname = pname;
	this.quantity = qty;
	this.price = price;
}





public String getPname() {
	return pname;
}


public void setPname(String pname) {
	this.pname = pname;
}




public int getProdid() {
	return prodid;
}


public void setProdid(int prodid) {
	this.prodid = prodid;
}


public int getQuantity() {
	return quantity;
}


public void setQuantity(int quantity) {
	this.quantity = quantity;
}


public float getPrice() {
	return price;
}


public void setPrice(float price) {
	this.price = price;
}


@Override
public String toString() {
	return "Product [pid=" + prodid + ", pname=" + pname + ", qty=" + quantity + ", price=" + price + "]";
}

}
