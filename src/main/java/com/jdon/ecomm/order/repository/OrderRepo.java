package com.jdon.ecomm.order.repository;

import com.jdon.ecomm.order.domain.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepo extends CrudRepository<Order, String> {
}
