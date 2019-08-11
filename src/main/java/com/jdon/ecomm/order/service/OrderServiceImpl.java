package com.jdon.ecomm.order.service;

import com.jdon.ecomm.order.domain.*;
import com.jdon.ecomm.order.repository.OrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepo orderRepo;

	@Override
	@PostMapping("/orders")
	public Order placeOrder(@RequestBody OrderItem orderItem2) {
		Order order = new Order();

		Address address = new Address();
		address.setStreet("no.1");
		address.setZip("10000");
		order.setM_Address(address);

		OrderItem orderItem = new OrderItem();
		orderItem.setProductId("1");
		orderItem.setQty(2);
		order.addItem(orderItem);

		orderItem = new OrderItem();
		orderItem.setProductId("2");
		orderItem.setQty(3);
		order.addItem(orderItem);

		return orderRepo.save(order);
	}

	@Override
	@PostMapping("/orders/payment")
	public Order payment(@RequestParam String orderId) {
		Order orderSaved2 = orderRepo.findById(orderId).orElse(new Order());
		if (orderSaved2.setM_OrderStatus(new Payment()))
			orderRepo.save(orderSaved2);
		return orderSaved2;
	}

	@Override
	@PostMapping("/orders/delivery")
	public Order delivery(@RequestParam String orderId) {
		Order orderSaved2 = orderRepo.findById(orderId).orElse(new Order());
		if (orderSaved2.setM_OrderStatus(new Delivery()))
			orderRepo.save(orderSaved2);
		return orderSaved2;
	}
}
