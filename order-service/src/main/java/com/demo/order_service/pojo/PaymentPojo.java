package com.demo.order_service.pojo;

import jakarta.persistence.Column;

public class PaymentPojo {
	
	private int paymentId;
	
	private int order_id;
	
	private String paymentType;
}
