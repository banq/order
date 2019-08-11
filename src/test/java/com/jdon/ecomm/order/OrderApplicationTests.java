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

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderApplicationTests {

	@Autowired
	OrderRepo orderRepo;

	@Test
	public void contextLoads() {
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

		Order orderSaved = orderRepo.save(order);

		assertThat(orderRepo.count()).isEqualTo(1);

		Order orderSaved2 = orderRepo.findById(orderSaved.getId()).orElse(new Order());
		orderSaved2.setM_OrderStatus(new Payment());
	}

}

