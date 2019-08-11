package com.jdon.ecomm.order.domain;


import org.springframework.data.annotation.Id;

/**
 * @author banq
 * @version 1.0
 * @created 14-12��-2018 14:40:28
 */
public class OrderStatus {

	protected int state = -1;
	@Id
	private String id;

	public OrderStatus(int state) {
		this.state = state;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public OrderStatus next() {
		if (state == 0)
			return new Payment();
		else if (state == 1)
			return new Delivery();
		else
			return new OrderStatus(-1);
	}
}