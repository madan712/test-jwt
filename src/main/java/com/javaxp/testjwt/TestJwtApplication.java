package com.javaxp.testjwt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestJwtApplication implements CommandLineRunner {

	@Autowired
	private JwtTokenService jwtTokenService;

	public static void main(String[] args) {
		SpringApplication.run(TestJwtApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user1 = new User();
		user1.setUserId(11L);
		user1.setFirstName("foo");
		user1.setLastName("bar");
		user1.setEmail("test@test.com");

		System.out.println(user1);

		String token = jwtTokenService.generateToken(user1);
		System.out.println(token);

		System.out.println(jwtTokenService.validateToken(token));

		User user2 = jwtTokenService.getUserFromToken(token);
		System.out.println(user2);
	}

}
