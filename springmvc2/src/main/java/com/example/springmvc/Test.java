package com.example.springmvc;


import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public class Test {

	static void show() {
		SingleConnectionDataSource ds = new SingleConnectionDataSource();
		ds.setDriverClassName("org.h2.Driver");
	    ds.setUrl("jdbc:h2:f:/abc");
	    ds.setUsername("sa");
	    ds.setPassword("");
	  
	    JdbcTemplate jt = new JdbcTemplate(ds);
	    jt.execute("DROP TABLE IF EXISTS product;  "
	    		+ "CREATE TABLE PRODUCT (  \n"
	    		+ "ID  INT AUTO_INCREMENT  PRIMARY KEY,  \n"
	    		+ "BRAND VARCHAR(50) NOT NULL,  \n"
	    		+ "CODE VARCHAR(50) NOT NULL,\n"
	    		+ "NAME  varchar(50) not null,\n"
	    		+ "UNITPRICE float(25) not null,\n"
	    		+ "QUANTITY  INT not null \n"
	    		+ ");  \n"
	    		+ "");
	}

	public static void main(String[] args) {
	
		show();
	}
}


