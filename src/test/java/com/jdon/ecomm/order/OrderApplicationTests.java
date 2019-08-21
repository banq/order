package com.jdon.ecomm.order;

import com.jdon.ecomm.order.domain.Address;
import com.jdon.ecomm.order.domain.Order;
import com.jdon.ecomm.order.domain.OrderItem;
import com.jdon.ecomm.order.domain.Payment;
import com.jdon.ecomm.order.repository.OrderRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Collection;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderApplicationTests {

	@Autowired
	OrderRepo orderRepo;

	@Test
	public void contextLoads() {

		Order order = Order.builder().withAddress(createMockAddress()).withItems(createMockitems()).build();

		Order orderSaved = orderRepo.save(order);

		assertThat(orderRepo.count()).isEqualTo(1);

		Order orderSaved2 = orderRepo.findById(orderSaved.getId()).orElse(new Order());
		orderSaved2.setM_OrderStatus(new Payment());
	}

	private Address createMockAddress(){

		Address address = new Address();
		address.setStreet("no.1");
		address.setZip("10000");
		return address;


	}

	private Collection<OrderItem> createMockitems() {
		Collection<OrderItem> items = new ArrayList<>();
		OrderItem orderItem = new OrderItem();
		orderItem.setProductId("1");
		orderItem.setQty(2);
		items.add(orderItem);

		orderItem = new OrderItem();
		orderItem.setProductId("2");
		orderItem.setQty(3);
		items.add(orderItem);
		return items;
	}
}

