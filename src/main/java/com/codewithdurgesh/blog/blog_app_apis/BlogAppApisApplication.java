package com.codewithdurgesh.blog.blog_app_apis;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.codewithdurgesh.blog.blog_app_apis.config.AppConstants;
import com.codewithdurgesh.blog.blog_app_apis.entities.Role;
import com.codewithdurgesh.blog.blog_app_apis.repositories.RolesRepo;

@SpringBootApplication
public class BlogAppApisApplication implements CommandLineRunner{

	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private RolesRepo rolesRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(BlogAppApisApplication.class, args);
		
	}
	
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		
<<<<<<< HEAD
		System.out.println(passwordEncoder.encode("hjgj"));
=======
		System.out.println(passwordEncoder.encode("abc"));
>>>>>>> 8896895971339f78d49ae75060a6b4e0391189a8
		
		try {
			
			Role role = new Role();
			role.setId(AppConstants.ADMIN_USER);
<<<<<<< HEAD
			role.setName("ADMIN");

			Role role1 = new Role();
			role1.setId(AppConstants.NORMAL_USER);
			role1.setName("NORMAL");
=======
			role.setName("ROLE_ADMIN");

			Role role1 = new Role();
			role1.setId(AppConstants.NORMAL_USER);
			role1.setName("ROLE_NORMAL");
>>>>>>> 8896895971339f78d49ae75060a6b4e0391189a8

			List<Role> roles = List.of(role, role1);

			List<Role> result = this.rolesRepo.saveAll(roles);

			result.forEach(r -> {
				System.out.println(r.getName());
			});
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
