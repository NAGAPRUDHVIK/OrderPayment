package com.demo.payment_service.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.payment_service.repository.entity.Payment;
import com.demo.payment_service.service.PaymentService;

@RestController
@RequestMapping("/api")
public class PaymentController {

	@Autowired
	PaymentService service;
	
	@GetMapping("/payments")
	private ResponseEntity< List<Payment>> getAllPayment(){
		return new ResponseEntity<List<Payment>>(service.getAllPayment(),HttpStatus.OK);
	}
	
	@GetMapping("/payments/{paymentId}")
	private ResponseEntity< Optional<Payment>> getPaymentsById(@PathVariable int paymentId){
		return new ResponseEntity<Optional<Payment>>(service.getPaymentById(paymentId),HttpStatus.OK);
	}
	
	@DeleteMapping("/payments/{paymentId}")
	private ResponseEntity<Void> deletePayment(@PathVariable int paymentId) {
		service.deletePayment(paymentId);
		return new ResponseEntity<Void>(HttpStatus.OK);
		
	}
}