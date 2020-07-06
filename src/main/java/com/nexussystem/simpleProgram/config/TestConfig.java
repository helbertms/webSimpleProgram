package com.nexussystem.simpleProgram.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.nexussystem.simpleProgram.entites.Category;
import com.nexussystem.simpleProgram.entites.Order;
import com.nexussystem.simpleProgram.entites.User;
import com.nexussystem.simpleProgram.entites.enuns.OrderStatus;
import com.nexussystem.simpleProgram.entites.repositories.CategoryRepository;
import com.nexussystem.simpleProgram.entites.repositories.OrderRepository;
import com.nexussystem.simpleProgram.entites.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{
	
	// --> 1 <--
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		
		User u1 = new User(null, "Arthur Souza", "arthur@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Thais Caroline", "thais@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.Pago, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.Aguardando_Pagamento, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.Aguardando_Pagamento, u1);
		
		
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		categoryRepository.saveAll(Arrays.asList(cat1 , cat2, cat3));
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
