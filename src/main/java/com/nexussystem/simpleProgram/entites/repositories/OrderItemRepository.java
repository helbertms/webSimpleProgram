package com.nexussystem.simpleProgram.entites.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nexussystem.simpleProgram.entites.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
