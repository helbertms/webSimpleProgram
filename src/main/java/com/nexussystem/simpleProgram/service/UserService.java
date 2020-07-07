package com.nexussystem.simpleProgram.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexussystem.simpleProgram.entites.User;
import com.nexussystem.simpleProgram.entites.repositories.UserRepository;

@Service
public class UserService {
	
	// O anotation Autowired faz com que o ispring faça  a injeção de dependência de forma transparente
	
	@Autowired
	private UserRepository repository;
	
	
	public List<User> findAll(){
		return repository.findAll();
	}	
	
	public User findById(Long id) {
	 	Optional<User> obj = repository.findById(id);
	 	return obj.get();
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	public void  delete(Long id) {
		repository.deleteById(id);
	}
	
	public User update(Long id, User obj) {
		User entity = repository.getOne(id);
		updateData (entity, obj);
		return repository.save(entity);
	}

	private void updateData(User entity, User obj) {
		entity.setNome(obj.getNome());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
	}

}
