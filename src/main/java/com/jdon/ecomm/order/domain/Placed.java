package com.jdon.ecomm.order.domain;

import org.springframework.data.relational.core.mapping.Table;

@Table("order_status")
public class Placed extends OrderStatus {
	public Placed() {
		super(0);
	}

	@Override
	public OrderStatus next() {
		return new Payment();
	}
}
