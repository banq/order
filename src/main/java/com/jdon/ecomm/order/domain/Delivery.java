package com.jdon.ecomm.order.domain;


import org.springframework.data.relational.core.mapping.Table;

/**
 * @author banq
 * @version 1.0
 * @created 14-12��-2018 14:40:30
 */
@Table("order_status")
public class Delivery extends OrderStatus {

	public Delivery() {
		super(2);//已发货

	}

	@Override
	public OrderStatus next() {
		return null;
	}
}