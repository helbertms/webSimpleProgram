package com.nexussystem.simpleProgram.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexussystem.simpleProgram.entites.Category;
import com.nexussystem.simpleProgram.entites.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	// O anotation Autowired faz com que o ispring faça  a injeção de dependência de forma transparente
	
	@Autowired
	private CategoryRepository repository;
	
	
	public List<Category> findAll(){
		return repository.findAll();
	}	
	
	public Category findById(Long id) {
	 	Optional<Category> obj = repository.findById(id);
	 	return obj.get();
	}

}
