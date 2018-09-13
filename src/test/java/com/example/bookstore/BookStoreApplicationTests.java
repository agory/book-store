package com.example.bookstore;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BookStoreApplicationTests {

	@BeforeClass
	public static void switchOffLiquibase() {
		System.setProperty("spring.liquibase.enabled", "false");
	}


	@Test
	public void contextLoads() {
	}

}
