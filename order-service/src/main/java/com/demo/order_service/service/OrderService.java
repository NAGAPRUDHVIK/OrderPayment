package com.demo.order_service.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.demo.order_service.repository.OrderRepository;
import com.demo.order_service.repository.entity.Order;

@Service
public class OrderService {

	@Autowired
	OrderRepository repo;

	public List<Order> getAllOrders(){
		return repo.findAll();
	}
	
	public Optional<Order> getOrderById(int orderId){
		return repo.findById(orderId);
	}
	
	public Order addOrder(Order newOrder) {
		return repo.saveAndFlush(newOrder);
	}
	
	public Order updateOrder(Order editOrder) {
		return repo.save(editOrder);
	}
	
	public void deletOrder(int orderId) {
		repo.deleteById(orderId);
	}
	
	@Bean
	public WebClient webClient() {
	    return WebClient.builder()
	                    .baseUrl("http://localhost:1221") 
	                    .build();
	}
}