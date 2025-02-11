package com.demo.payment_service.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.demo.payment_service.repository.PaymentRepository;
import com.demo.payment_service.repository.entity.Payment;


@Service
public class PaymentService {
	
	@Autowired
	PaymentRepository repo;
	
	@KafkaListener(topics = "order-payment", groupId = "payment-group")
	public void listenToOrder(String payment) {
		System.out.println("Received payment from Kafka: " + payment);
	}
	
	public List<Payment> getAllPayment(){
		return repo.findAll();
	}
	
	public Optional<Payment> getPaymentById(int paymentId){
		return repo.findById(paymentId);
	}
	
	public void deletePayment(int paymentId) {
		repo.deleteById(paymentId);
	}
}