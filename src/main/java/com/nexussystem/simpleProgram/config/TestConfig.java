package com.nexussystem.simpleProgram.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.nexussystem.simpleProgram.entites.Category;
import com.nexussystem.simpleProgram.entites.Order;
import com.nexussystem.simpleProgram.entites.OrderItem;
import com.nexussystem.simpleProgram.entites.Payment;
import com.nexussystem.simpleProgram.entites.Product;
import com.nexussystem.simpleProgram.entites.User;
import com.nexussystem.simpleProgram.entites.enuns.OrderStatus;
import com.nexussystem.simpleProgram.entites.repositories.CategoryRepository;
import com.nexussystem.simpleProgram.entites.repositories.OrderItemRepository;
import com.nexussystem.simpleProgram.entites.repositories.OrderRepository;
import com.nexussystem.simpleProgram.entites.repositories.ProductRepository;
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
	
	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;

	@Override
	public void run(String... args) throws Exception {

		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");
		
		categoryRepository.saveAll(Arrays.asList(cat1 , cat2, cat3));

		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		p1.getCategories().add(cat2);
		p2.getCategories().add(cat1);
		p2.getCategories().add(cat3);
		p3.getCategories().add(cat3);
		p4.getCategories().add(cat1);
		p4.getCategories().add(cat3);
		p5.getCategories().add(cat2);
		
		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));
		
		
		User u1 = new User(null, "Arthur Souza", "arthur@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Thais Caroline", "thais@gmail.com", "977777777", "123456");
		
		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.Pago, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.Aguardando_Pagamento, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.Aguardando_Pagamento, u1);
		
		
		userRepository.saveAll(Arrays.asList(u1, u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		OrderItem oi1 = new OrderItem(o1, p1, 2, p1.getPrice());
		OrderItem oi2 = new OrderItem(o1, p3, 1, p3.getPrice());
		OrderItem oi3 = new OrderItem(o2, p3, 2, p3.getPrice());
		OrderItem oi4 = new OrderItem(o3, p5, 2, p5.getPrice());
		
		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
		
		Payment pay1 = new Payment(null, Instant.parse("2019-06-20T21:53:07Z"),o1);
		o1.setPayment(pay1);
		orderRepository.save(o1);
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
