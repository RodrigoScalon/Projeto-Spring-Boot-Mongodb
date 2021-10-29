package com.rodrigoscalon.workshopmongo.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rodrigoscalon.workshopmongo.domain.User;
import com.rodrigoscalon.workshopmongo.repository.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		
		userRepository.deleteAll();
		
		User thor = new User(null, "Thor", "Thor@gmail.com");
		User logan = new User(null, "Wolverine", "Wolverine@gmail.com");
		User selina = new User(null, "Catwoman", "catwoman@gmail.com");

		userRepository.saveAll(Arrays.asList(thor, logan, selina));
		
		
	}

}
