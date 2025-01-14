package com.demo.order_service.pojo;

import java.time.LocalDate;
import java.util.List;


public class OrderPaymentPojo {

    private int orderId;
    
    private LocalDate orderDate;
    
    private int orderPrice;
    
    private List<PaymentPojo> allpayment;

	
}
