package com.codewithdurgesh.blog.blog_app_apis;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.codewithdurgesh.blog.blog_app_apis.entities.User;
import com.codewithdurgesh.blog.blog_app_apis.repositories.UserRepo;

@SpringBootTest
class BlogAppApisApplicationTests {

	@Autowired
	private UserRepo userRepo;
	
	
	
	@Test
	void contextLoads() {
	}
	
	@Test
	void test() {
		String name= userRepo.getClass().getName();
		String pkg = userRepo.getClass().getPackageName();
		System.out.println(name + " " + pkg);
	}

}
