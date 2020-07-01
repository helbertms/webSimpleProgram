package com.nexussystem.simpleProgram.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexussystem.simpleProgram.entites.User;

@RestController
@RequestMapping (value = "/users")
public class UserResources {
	
	@GetMapping
	public ResponseEntity<User> findAll(){
		User u = new User(1L, "Arthur", "arthur@gmail.com", "99999999", "123456");
		return ResponseEntity.ok().body(u);
	}
}
