package com.example.demo;


import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.entity.Produit;
import com.example.demo.entity.Role;
import com.example.demo.repository.ProduitRepository;
import com.example.demo.repository.RoleRepository;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
public class ServeurGestionStockProduitsApplication implements CommandLineRunner {

	@Autowired
	private ProduitRepository produitRepository;
	
	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(ServeurGestionStockProduitsApplication.class, args);
		
		/*
		ProduitRepository produitRepository = ctx.getBean(ProduitRepository.class);
		
		produitRepository.save(new Produit("Livre", 50, 20));
		produitRepository.save(new Produit("Cahier", 200, 5.25f));
		produitRepository.save(new Produit("Stylo", 500, 2.10f));
		
		RoleRepository roleRepository = ctx.getBean(RoleRepository.class);
		
		Role roleUser = new Role("ROLE_USER");
		Role roleAdmin = new Role("ROLE_ADMIN");
		
		roleRepository.save(roleUser);
		roleRepository.save(roleAdmin);
		
		UserRepository userRepository = ctx.getBean(UserRepository.class);
		
		com.example.demo.entity.User user = new com.example.demo.entity.User("user1", "password1" , true);
		user.setRoles(Arrays.asList(roleUser));
		com.example.demo.entity.User user2 = new com.example.demo.entity.User("admin","admin", true);
		user2.setRoles(Arrays.asList(roleUser, roleAdmin));
		
		userRepository.save(user);
		userRepository.save(user2);
		*/
		
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*produitRepository.save(new Produit("Livre", 50, 20));
		produitRepository.save(new Produit("Cahier", 200, 5.25f));
		produitRepository.save(new Produit("Stylo", 500, 2.10f)); */
		
		produitRepository.findAll().forEach(c ->{
					System.out.println(c.getRef());
				});
	}
	
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();		
	}
}


