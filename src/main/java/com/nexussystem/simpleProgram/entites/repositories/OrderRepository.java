package com.nexussystem.simpleProgram.entites.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexussystem.simpleProgram.entites.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
