package com.engineeringdigest.journalApp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import com.engineeringdigest.journalApp.common.UserArgumentsProvider;
import com.engineeringdigest.journalApp.entity.User;

@SpringBootTest
//@ActiveProfiles("dev")
public class UserServiceDemoTest {

	@Autowired
	UserServiceDemo userServiceDemo;
	
	@Disabled // mreko nahi chalana ye test bc ab
	@Test
	public void testAddition() {

		assertEquals(4, 3 + 1);
		assertTrue(5 > 1);
	}

	@Test
	public void testGettingUsernames() {
		assertNotNull(userServiceDemo.getUserAll());
	}

	@Test
	public void checkUserName() {

		List<User> users = userServiceDemo.getUserAll();
		if (users.size() > 0) {
			String name = users.get(0).getUserName();
			assertTrue("verma".equals(name));
		}

	}

	// parameterized kar do please

	@ParameterizedTest
	// @CsvFileSource // file de sakta mai test cases wali
	@CsvSource({ "1,1,2", "9,5,14", "0,1,3" })
	public void additonButParamWala(int a, int b, int expectedOutput) {

		assertEquals(expectedOutput, a + b);
	}

	@ParameterizedTest
	@ValueSource(strings = { "tarun", "verma", "huhhe" })
	public void checkUserNameButParameetrize(String inputName) {

		List<User> users = userServiceDemo.getUserAll();
		if (users.size() > 0) {
			String name = users.get(0).getUserName();
			assertTrue(inputName.equals(name), "fail for " + inputName);

		}
	}

	@BeforeEach
//	@BeforeAll
//	@AfterAll
//	@AfterEach
	void setUp() {
		// sare test se pahle ye chalega 
		System.out.println("chal gyaa mai ....");
	}
	
	@ParameterizedTest
	@ArgumentsSource(UserArgumentsProvider.class)
	public void checkUserNameButParameetrizeSourceClass(User user) {

		List<User> users = userServiceDemo.getUserAll();
		if (users.size() > 0) {
			String name = users.get(0).getUserName();
			assertTrue(user.getUserName().equals(name), "fail for " + user.getUserName());

		}
	}
}
