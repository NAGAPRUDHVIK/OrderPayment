package com.demo.order_service.pojo;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PaymentPojo {

	private int paymentId;
	
	private String paymentType;
	
	private int orderId;
	
}
