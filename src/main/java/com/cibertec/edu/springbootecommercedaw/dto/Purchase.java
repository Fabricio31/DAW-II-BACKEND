package com.cibertec.edu.springbootecommercedaw.dto;

import java.util.Set;

import com.cibertec.edu.springbootecommercedaw.model.Address;
import com.cibertec.edu.springbootecommercedaw.model.Customer;
import com.cibertec.edu.springbootecommercedaw.model.Order;
import com.cibertec.edu.springbootecommercedaw.model.OrderItem;

import lombok.Data;

@Data
public class Purchase {	
	
	//Agregando
	private Customer customer;
	private Address shippingAddress;
	private Address billingAddress;
	private Order order;
	private Set<OrderItem> orderItems;
	

}
