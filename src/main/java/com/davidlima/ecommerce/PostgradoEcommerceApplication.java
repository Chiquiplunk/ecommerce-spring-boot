package com.davidlima.ecommerce;

import com.davidlima.ecommerce.entity.Category;
import com.davidlima.ecommerce.entity.Product;
import com.davidlima.ecommerce.entity.Role;
import com.davidlima.ecommerce.repository.CategoryRepository;
import com.davidlima.ecommerce.repository.ProductRepository;
import com.davidlima.ecommerce.repository.RoleRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PostgradoEcommerceApplication {

	public static void main(String[] args) {
		SpringApplication.run(PostgradoEcommerceApplication.class, args);
	}
}
