package com.cibertec.edu.springbootecommercedaw.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.cibertec.edu.springbootecommercedaw.dto.Purchase;
import com.cibertec.edu.springbootecommercedaw.dto.PurchaseResponse;

public interface CheckoutService {
	
	@Autowired
	PurchaseResponse placeOrder(Purchase purchase);
	

}
