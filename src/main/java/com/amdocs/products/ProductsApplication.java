package com.amdocs.products;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
@Slf4j
public class ProductsApplication {
	private static final Logger log = LoggerFactory.getLogger(ProductsApplication.class);

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(ProductsApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8082"));
		app.run(args);
		log.info("Mercy Jacqueline Trujillo Rodriguezzzzzz");

	};


}
