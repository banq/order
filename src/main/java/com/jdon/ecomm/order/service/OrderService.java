package com.jdon.ecomm.order.service;


import com.jdon.ecomm.order.domain.Order;
import com.jdon.ecomm.order.domain.OrderItem;

/**
 * @author banq
 * @version 1.0
 * @created 14-12��-2018 15:02:01
 */
public interface OrderService {

	/**
	 * @param orderItem
	 */
	public Order placeOrder(OrderItem orderItem);

	/**
	 * @param orderId
	 */
	public Order payment(String orderId);

	/**
	 * @param orderId
	 */
	public Order delivery(String orderId);

}