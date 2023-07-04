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

	public void save(Product p) {
		jdbcTemplate.update("insert into productss values(?,?,?,?)",
				new Object[] {p.getProdid(),p.getPname(),p.getQuantity(),p.getPrice()});
	}

	@Override
	public List<Product> getAll() {
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
	public boolean removeById(int pid) {
	  int n=jdbcTemplate.update("delete from products where prodid=?",new Object[] {pid});
	  if(n>0)
		  return true;
		return false;
	}

	@Override
	public boolean modifyById(int pid, String pname, float price) {
	    int n=jdbcTemplate.update("update productss set pname=?, price=? where prodid=?",new Object[] {pname,price,pid});
	    if(n>0)
	    	return true;
		return false;
	}

	@Override
	public Product getById(int prodid) throws EmptyResultDataAccessException{
		Product p=jdbcTemplate.queryForObject("select * from productss where prodid=?",new Object[]{prodid},BeanPropertyRowMapper.newInstance(Product.class));
		
		return p;
	}

	@Override
	public List<Product> sortByPrice() {
		List<Product> plist=jdbcTemplate.query("select * from productss order by price desc", BeanPropertyRowMapper.newInstance(Product.class));
	    return plist;
	}
}
