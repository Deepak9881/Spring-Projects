package com.demo.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.demo.beans.Product;

@Repository
public class ProductDaoImpl implements ProductDao{
@Autowired
private JdbcTemplate jdbcTemplate;



	@Override
	public List<Product>getAll() {
	  List<Product>plist=jdbcTemplate.query("select * from productss", new RowMapper() {

		@Override
		public Object mapRow(ResultSet rs, int rowNum) throws SQLException {
			Product p=new Product();
			p.setProdid(rs.getInt(1));
	        p.setPname(rs.getString(2));
	        p.setQuantity(rs.getInt(3));
	        p.setPrice(rs.getFloat(4));
			return p;
		}
		});
//		List<Product> plist=jdbcTemplate.query("select * from productss",
//				BeanPropertyRowMapper.newInstance(Product.class));
		return plist;
	}



	@Override
	public void addnewProduct(int prodid, String pname, int qty, float price) {
	   jdbcTemplate.update("insert into productss values(?,?,?,?)",new Object[] {prodid,pname,qty,price});
	}



	@Override
	public Product getById(int prodid) {
		return jdbcTemplate.queryForObject("Select * from productss where prodid=?",new Object[] {prodid},BeanPropertyRowMapper.newInstance(Product.class));
	}



	@Override
	public void updateProduct(int prodid, String pname, int qty, float price) {
	  jdbcTemplate.update("update productss set pname=?, quantity=?,price=? where prodid=?",
			  new Object[] {pname,qty,price,prodid});
		
	}



	@Override
	public void removeById(int prodid) {
		jdbcTemplate.update("delete from productss where prodid=?",new Object[] {prodid});
		
	}


}
