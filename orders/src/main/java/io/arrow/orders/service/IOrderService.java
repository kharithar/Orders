package io.arrow.orders.service;

import java.util.List;

import io.arrow.orders.model.OrderPersistance;

public interface IOrderService {
	public List<OrderPersistance> findOrders(Integer limit,Integer[] parts);
	
	public OrderPersistance addOrder(OrderPersistance order);
	
}
