package com.dronebuzzers.parts.repositories.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dronebuzzers.parts.repositories.order.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
	
	Order findByDbOrderNumber(String id);


}
