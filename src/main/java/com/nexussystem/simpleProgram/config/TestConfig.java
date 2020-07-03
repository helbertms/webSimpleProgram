package com.nexussystem.simpleProgram.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.nexussystem.simpleProgram.entites.User;
import com.nexussystem.simpleProgram.entites.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	// --> 1 <--
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		
		userRepository.saveAll(Arrays.asList(u1, u2));
	}
	

	/*
	 *  --1--
	 *  Boas práticas de programação --> Quando um serviço depende da outro utiliza-se 
	 *  a "injeção de dependêndia" e essa por sua vez tem que ser "fraca / desacoplada"
	 *  
	 *  Há portanto várias formas de fazer essa dependência manualmente, como por exemplo através de um 
	 *  construtor ou por um padrão fabrica por um método "set" e etc...
	 *  
	 *  No caso desta classe criamos a dependência "userRepository" com o anotation "Autowired" que tem um 
	 *  mecanismo de injeção de independencia implicito
	 */
}
