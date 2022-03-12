package com.example.springmvc.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import org.springframework.stereotype.Repository;

import com.example.springmvc.dao.ProductServiceDao;
import com.example.springmvc.model.Product;




@Repository
public class ProductServiceImp implements ProductServiceDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    

  

class ProductRowMapper implements RowMapper < Product > {
      
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
    	Product product = new Product();
       
    	product.setId(rs.getLong("id"));
    	product.setBrand(rs.getString("brand"));
    	product.setCode(rs.getString("code"));
    	product.setName(rs.getString("name"));
    	product.setQuantity(rs.getInt("quantity"));
    	product.setUnitprice(rs.getDouble("unitprice"));
        return product;
    }

}


	public List<Product> getAllProducts(){
        return jdbcTemplate.query("select * from PRODUCT", new ProductRowMapper());
    }
	
	 // add product
	public int addProduct(Product product) {
		
		return jdbcTemplate.update("insert into PRODUCT (brand, code, name, quantity, unitprice) " + "values(?, ?, ?, ?, ?)",
				new Object[] { product.getBrand(), product.getCode(), product.getName(),
						product.getQuantity(), product.getUnitprice() });
	}
	
	

	public int updateProduct(Product product) {
        return jdbcTemplate.update("update PRODUCT " + " set brand = ?, code = ?, name = ?,qunatity = ?, unitprice = ? " + " where id = ?",
        		new Object[] { product.getBrand(), product.getCode(), product.getName(),
						product.getQuantity(), product.getUnitprice() });
    }

	  // delete by id
	public int deleteById(long id) {
        return jdbcTemplate.update("delete from PRODUCT where id=?", new Object[] {
            id
        });
    }
	
	
	   //GET by id
    public Product getProdcutById(long id) {
        String sql = "SELECT * FROM PRODUCT where id=?";
        RowMapper<Product> rowMapper = new BeanPropertyRowMapper<Product>(Product.class);
        Product product = jdbcTemplate.queryForObject(sql, rowMapper, id);
        return product;

    }



	@Override
	public Product getProductByName(String productname) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @Override public List<Product> searchbrand(String name) {
	 * 
	 * return jdbcTemplate.query("SELECT * FROM PRODUCT " + "WHERE brand LIKE '" +
	 * name + "%';", new ProductRowMapper());
	 * 
	 * }
	 */
	

	    public List<Product> findByBrand(String brand) {
	        return jdbcTemplate.query(
	                "select * from product where brand like ? ",
	                new Object[]{"%" + brand },
	                (rs, rowNum) ->
	                        new Product(
	                                rs.getLong("id"),
	                                rs.getString("brand")
	                              
	                        )
	        );
	    }

		@Override
		public List<Product> searchbrand(String name) {
			// TODO Auto-generated method stub
			return null;
		}





}

