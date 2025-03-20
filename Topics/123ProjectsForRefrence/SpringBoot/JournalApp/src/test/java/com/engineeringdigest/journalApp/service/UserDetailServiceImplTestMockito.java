package com.engineeringdigest.journalApp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;

import com.engineeringdigest.journalApp.entity.User;
import com.engineeringdigest.journalApp.repository.UserRepository;

//@SpringBootTest // it load all the components and we don't want that
public class UserDetailServiceImplTestMockito {

	//@Autowired // need spring context
	@InjectMocks // will inject dependencies
	private UserDetailServiceImpl userDetailServiceImpl; 
	
	//@MockBean  // need spring context
	@Mock
	private UserRepository userRepository; // but this will be null so
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this); // will initialize userRepository
	}
	
	@Test
	void loadUserByUsername() {
		
		// here we are returning the demo info when repository method calls , data db se nahi aayega
		//when(userRepository.findByName("tarun")).thenReturn(User.builder().userName("tarun").password("1234").build());
		
	
		// koi si bhi string aaaaye
		when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().userName("tarun").password("1234").build());
	  
		
		UserDetails user = userDetailServiceImpl.loadUserByUsername("tarun");
		assertEquals("verma", user.getUsername());
		System.out.println("in test "+user.getUsername());
	}
}

