package com.cibertec.edu.springbootecommercedaw.service;

import java.util.Set;
import java.util.UUID;

import org.springframework.stereotype.Service;

import com.cibertec.edu.springbootecommercedaw.dto.Purchase;
import com.cibertec.edu.springbootecommercedaw.dto.PurchaseResponse;
import com.cibertec.edu.springbootecommercedaw.model.Customer;
import com.cibertec.edu.springbootecommercedaw.model.Order;
import com.cibertec.edu.springbootecommercedaw.model.OrderItem;
import com.cibertec.edu.springbootecommercedaw.repository.CustomerRepository;

import jakarta.transaction.Transactional;

@Service
public class CheckoutServicempl implements CheckoutService {
    //Implementar metodos
    private CustomerRepository customerRepository;

    public CheckoutServicempl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    @Transactional
    public PurchaseResponse placeOrder(Purchase purchase) {
        //Recuperar la información del pedido desde dto
        Order order = purchase.getOrder();
        //generar número de seguimiento
        String orderTrackingNumber = generateOrderTrackingNumber();
        order.setOrderTrackingNumber(orderTrackingNumber);
        //completar el pedido con orderItems
        Set<OrderItem> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> order.add(item));
        //completar el pedido con billingAddress y ShippingAddress
        order.setBillingAddress(purchase.getBillingAddress());
        order.setShippingAddress(purchase.getShippingAddress());
        //Llenar cliente con pedido
        Customer customer = purchase.getCustomer();
		//2:45pm-- Verificar si el cliente ya existe
		String theEmail = customer.getEmail();
		Customer customerFromDB = customerRepository.findByEmail(theEmail);
		if(customerFromDB != null){
			//Si se encuentra cliente
			customer = customerFromDB;
		}
		//2:45pm-- FIN
        customer.add(order);
        //guardar en la base
        customerRepository.save(customer);
        //devolver una respuesta
        return new PurchaseResponse(orderTrackingNumber);
    }

    private String generateOrderTrackingNumber() {
        // generate a ramdom UUID number (UUID Version-4)
        return UUID.randomUUID().toString();

    }


}
















