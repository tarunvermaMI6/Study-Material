package com.engineeringdigest.journalApp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.engineeringdigest.journalApp.entity.User;
import com.engineeringdigest.journalApp.repository.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j // lombork ki dependency
public class UserDetailServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	// @Autowired
	// EnvService envService;

//	private static final Logger logger = LoggerFactory.getLogger(UserDetailServiceImpl.class);

	@Autowired
	RestTemplate resttemplate;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		/*
		 * UserMetadataModel userMetadataModel = new UserMetadataModel(); List<User>
		 * userList = userMetadataModel.getUserList(); System.out.println("roles ==== "
		 * + userList); User user = (User) userList.stream().map(x -> {
		 * 
		 * if (x.getUserName().equals(username)) { return x; } return null; });
		 * 
		 * if (user != null) {
		 * 
		 * UserDetails userDetails =
		 * org.springframework.security.core.userdetails.User.builder()
		 * .username(user.getUserName()).password(user.getPassword()).roles(user.
		 * getRoles()).build(); return userDetails; }
		 * 
		 * throw new RuntimeException("User not found ::: " + username);
		 */
		// System.out.println("in username service "+envService.getActiveProfile());
		User user = userRepository.findByUserName(username);
		if (user != null) {

			UserDetails userDetails = org.springframework.security.core.userdetails.User.builder()
					.username(user.getUserName()).password(user.getPassword()).build();
			return userDetails;
		}

		throw new RuntimeException("no user found ...............");
	}

	public void saveUser(User user) {

		/*
		 * logger.info("here in  save user ...........info");
		 * logger.debug("here in  save user ...........debug"); // disabled by default
		 * logger.trace("here in  save user ...........trace");// disabled by default
		 * logger.error("here in  save user ...........error");
		 * logger.warn("here in  save user ...........warn");
		 */

		try {
			userRepository.save(user);
			throw new RuntimeException("error in saving error");
		} catch (Exception e) {
			// throw new RuntimeException("error in saving error");
			// logger.error("error aa gai for {}",user.getUserName(),e);
			log.error("error hai mia ...........");
		}
	}

	public User getUserByName(String name) {

		return userRepository.findByUserName(name);
	}

	// group could be same if same topic have diffrent partions, if 
	
	// If each listener uses a different consumer group, both listeners receive all messages independently.
	
//	@KafkaListener(topics = "food", groupId = "food-1") // groupid = consumer group he hai
	
	@KafkaListener(topics = "food", groupId = "food-0") // groupid = consumer group he hai
	public void listen0(String message) {

		log.info("kafka consumer0 getting called .......");

		
//		ResponseEntity<String> resp = resttemplate.exchange("http://localhost:8080/user/checkConsumer?name=tarun", HttpMethod.GET,
	//			null, String.class);
//		System.out.println(resp.getBody());

	}
	
//	@KafkaListener(topics = "food", groupId = "food-1") // groupid = consumer group he hai
	@KafkaListener(topics = "food", groupId = "food-1")
	public void listen1(String message) {

		log.info("kafka consumer1 getting called .......");

	
	}
	
	//@KafkaListener(topics = "food", groupId = "food-0")
	@KafkaListener(topics = "food", groupId = "food-2") // groupid = consumer group he hai
	public void listen2(String message) {

		log.info("kafka consumer2 getting called .......");


	}
}
