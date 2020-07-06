package com.nexussystem.simpleProgram.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexussystem.simpleProgram.entites.Order;
import com.nexussystem.simpleProgram.entites.repositories.OrderRepository;

@Service
public class OrderService {
	
	// O anotation Autowired faz com que o ispring faça  a injeção de dependência de forma transparente
	
	@Autowired
	private OrderRepository repository;
	
	
	public List<Order> findAll(){
		return repository.findAll();
	}	
	
	public Order findById(Long id) {
	 	Optional<Order> obj = repository.findById(id);
	 	return obj.get();
	}

}
