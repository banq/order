package com.jdon.ecomm.order.domain;


import org.springframework.data.relational.core.mapping.Table;

/**
 * @author banq
 * @version 1.0
 * @created 14-12��-2018 14:40:29
 */
@Table("order_status")
public class Payment extends OrderStatus {

	public Payment() {
		super(1);//表示已支付
	}

	public OrderStatus next() {
		return new Delivery();
	}
}