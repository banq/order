package com.jdon.ecomm.order.domain;


/**
 * @author banq
 * @version 1.0
 * @created 14-12��-2018 14:40:24
 */
public class OrderItem {

	private String productId;
	private int qty;

	public OrderItem() {

	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}
}