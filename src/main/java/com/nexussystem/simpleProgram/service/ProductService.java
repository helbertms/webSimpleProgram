package com.nexussystem.simpleProgram.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexussystem.simpleProgram.entites.Product;
import com.nexussystem.simpleProgram.entites.repositories.ProductRepository;

@Service
public class ProductService {
	
	// O anotation Autowired faz com que o ispring faça  a injeção de dependência de forma transparente
	
	@Autowired
	private ProductRepository repository;
	
	
	public List<Product> findAll(){
		return repository.findAll();
	}	
	
	public Product findById(Long id) {
	 	Optional<Product> obj = repository.findById(id);
	 	return obj.get();
	}

}
