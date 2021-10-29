package com.rodrigoscalon.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rodrigoscalon.workshopmongo.domain.User;

@RestController
@RequestMapping (value = "/users")
public class UserResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public ResponseEntity <List<User>> findAll () {
		
		User batman = new User("1", "Bruce Wayne", "bruce@gmail.com");
		User wolverine = new User("2", "Logan", "logan@gmail.com");
		List <User> list = new ArrayList<>();
		list.addAll(Arrays.asList(batman, wolverine));
		
		return ResponseEntity.ok().body(list);		
		
	}

}
