package com.rodrigoscalon.workshopmongo.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.rodrigoscalon.workshopmongo.domain.Post;
import com.rodrigoscalon.workshopmongo.domain.User;
import com.rodrigoscalon.workshopmongo.dto.AuthorDTO;
import com.rodrigoscalon.workshopmongo.repository.PostRepository;
import com.rodrigoscalon.workshopmongo.repository.UserRepository;


@Configuration
public class Instantiation implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PostRepository postRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
				
		
		userRepository.deleteAll();
		postRepository.deleteAll();
		
		User thor = new User(null, "Thor", "Thor@gmail.com");
		User logan = new User(null, "Wolverine", "Wolverine@gmail.com");
		User selina = new User(null, "Catwoman", "catwoman@gmail.com");

		userRepository.saveAll(Arrays.asList(thor, logan, selina));

		Post post1 = new Post(null, sdf.parse("21/10/2021"), "Let's go", "Go to Gotham City!", new AuthorDTO (logan));
		Post post2 = new Post(null, sdf.parse("19/10/2021"), "No way", "Where are they?", new AuthorDTO (thor));

		postRepository.saveAll(Arrays.asList(post1, post2));
		
		logan.getPosts().addAll(Arrays.asList(post1));
		userRepository.save(logan);
		thor.getPosts().addAll(Arrays.asList(post1));
		userRepository.save(thor);
		
		
	}

}
