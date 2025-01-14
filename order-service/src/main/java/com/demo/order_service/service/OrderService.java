package com.demo.order_service.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.demo.order_service.constant.AppConstant;
import com.demo.order_service.pojo.OrderPojo;
import com.demo.order_service.pojo.PaymentPojo;
import com.demo.order_service.repository.OrderRepository;
import com.demo.order_service.repository.entity.Order;

@Service
public class OrderService {

	@Autowired
	OrderRepository repo;
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	
	public Order createOrder(OrderPojo orderPojo) {
    	Order orderEntity = new Order();
    	BeanUtils.copyProperties(orderPojo, orderEntity);
        Order savedOrder = repo.save(orderEntity);
        orderPojo.getPayment().setPaymentId(savedOrder.getOrderId());
        kafkaTemplate.send(AppConstant.TOPIC_ORDER_PAYMENT, orderPojo.getPayment().toString());
        return savedOrder;
    }

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
	
//	@Bean
//	public WebClient webClient() {
//	    return WebClient.builder()
//	                    .baseUrl("http://localhost:1221") 
//	                    .build();
//	}
}