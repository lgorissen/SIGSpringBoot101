package com.dronebuzzers.parts.repositories.order.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dronebuzzers.parts.repositories.order.OrderLine;

@Repository
public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {


}