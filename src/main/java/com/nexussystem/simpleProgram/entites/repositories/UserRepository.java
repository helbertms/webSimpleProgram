package com.nexussystem.simpleProgram.entites.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexussystem.simpleProgram.entites.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
