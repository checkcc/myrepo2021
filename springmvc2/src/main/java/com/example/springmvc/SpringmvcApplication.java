package com.example.springmvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

@SpringBootApplication

public class SpringmvcApplication {
	

	public static void main(String[] args) {
		SpringApplication.run(SpringmvcApplication.class, args);
	
	}
}
