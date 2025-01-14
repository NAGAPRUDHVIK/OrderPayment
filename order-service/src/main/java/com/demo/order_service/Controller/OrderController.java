package com.demo.order_service.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.demo.order_service.pojo.OrderPojo;
import com.demo.order_service.pojo.PaymentPojo;
import com.demo.order_service.repository.entity.Order;
import com.demo.order_service.service.OrderService;

@RestController
@RequestMapping("/api")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@PostMapping("/create")
    public ResponseEntity<String> createOrder(@RequestBody OrderPojo orderPojo) {
    	orderService.createOrder(orderPojo);
        return ResponseEntity.ok("Order created and payment processed!");
    }
	
	@GetMapping("/orders")
	public ResponseEntity<List<Order>> getAllOrders(){
		return new ResponseEntity<List<Order>>(orderService.getAllOrders(),HttpStatus.OK);
	}
	
	@GetMapping("/orders/{orderId}")
	public ResponseEntity< Optional<Order> > getOrderById(@PathVariable	int orderId){
		return new ResponseEntity<Optional<Order>>(orderService.getOrderById(orderId),HttpStatus.OK);
	}
	
	@PostMapping("/orders")
	public ResponseEntity< Order> addOrder(@RequestBody Order newOrder) {
		return new ResponseEntity<Order>(orderService.addOrder(newOrder),HttpStatus.OK);
	}
	
	@PutMapping("/orders")
	public ResponseEntity< Order> updateOrder(@RequestBody Order editOrder) {
		return new ResponseEntity<Order>(orderService.updateOrder(editOrder),HttpStatus.OK);
	}
	
	@DeleteMapping("/orders/{orderId}")
	public ResponseEntity<Void> deletOrder(@PathVariable int orderId) {
		orderService.deletOrder(orderId);
		return new ResponseEntity<Void>(HttpStatus.OK);
	
	} 

}