package com.nexussystem.simpleProgram.entites.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexussystem.simpleProgram.entites.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

}
