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

		System.out.println(jwtTokenService.validateToken("eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJ7XCJ1c2VySWRcIjoxMSxcImZpcnN0TmFtZVwiOlwiZm9vXCIsXCJsYXN0TmFtZVwiOlwiYmFyXCIsXCJlbWFpbFwiOlwidGVzdEB0ZXN0LmNvbVwifSIsImlhdCI6MTYzMjU5MTMzMywiZXhwIjoxNjMyNTk0OTMzLCJpc3MiOiJqYXZheHAuY29tIn0.29GZ8x5B5s7SWvdfOTNG_OfRry-PHtWtmQsibBdPRk1zGCxOVYRdZ1bXzEJmVI0hd0r1BHz-mOfan1EW_e8Ndw"));

		User user2 = jwtTokenService.getUserFromToken(token);
		System.out.println(user2);
	}

}
