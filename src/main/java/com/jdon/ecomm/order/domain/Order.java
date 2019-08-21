package com.jdon.ecomm.order.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.ArrayList;
import java.util.Collection;


/**
 * @author banq
 * @version 1.0
 * @updated 14-12��-2018 14:40:19
 */
@Table("order_table")
public class Order {

	private Collection<OrderItem> items;
	private Address m_Address;
	private OrderStatus m_OrderStatus;
	@Id
	private String id;

	public Order() {
		items = new ArrayList<>();
		m_OrderStatus = new Placed();
	}

	public void addItem(OrderItem item) {
		items.add(item);
	}

	public Collection<OrderItem> getItems() {
		return items;
	}

	public void setItems(Collection<OrderItem> items) {
		this.items = items;
	}

	public Address getM_Address() {
		return m_Address;
	}

	public void setM_Address(Address m_Address) {
		this.m_Address = m_Address;
	}

	public OrderStatus getM_OrderStatus() {
		return m_OrderStatus;
	}

	public boolean setM_OrderStatus(OrderStatus m_OrderStatus) {
		OrderStatus orderStatusN = getM_OrderStatus().next();
		if (orderStatusN.getState() == m_OrderStatus.getState()) {
			this.m_OrderStatus = orderStatusN;
			return true;
		} else
			return false;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	private Order(Address address, Collection<OrderItem> items) {
		this.m_Address = address;
		this.items = items;
		this.m_OrderStatus = new Placed();
	}

	public static OrderVOBuilder builder() {
		return new OrderVOBuilder();
	}

	public static class OrderVOBuilder{
		private Address address;
		private Collection<OrderItem> items;
		public OrderVOBuilder withAddress(Address address) {
		    this.address = address;
			return this;
		}
		public OrderVOBuilder withItems(Collection<OrderItem> items) {
            this.items = items;
			return this;
		}
		public Order build() {
			return new Order(address, items);
		}
	}
}