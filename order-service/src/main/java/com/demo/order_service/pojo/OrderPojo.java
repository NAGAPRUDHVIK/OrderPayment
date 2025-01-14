package com.demo.order_service.pojo;

import java.time.LocalDate;

import com.demo.order_service.repository.entity.Order;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class OrderPojo {
	
	private int orderId;
    private LocalDate orderDate;
    private int orderPrice;
	private PaymentPojo payment;

}
