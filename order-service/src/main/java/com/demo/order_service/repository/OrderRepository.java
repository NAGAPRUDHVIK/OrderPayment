package com.demo.order_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.demo.order_service.repository.entity.Order;



@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
}
