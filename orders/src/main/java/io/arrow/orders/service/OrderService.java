package io.arrow.orders.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.arrow.orders.dao.OrderDAO;
import io.arrow.orders.exception.OrdersNotFoundException;
import io.arrow.orders.model.OrderPersistance;
@Service
public class OrderService {
	
	@Autowired
	OrderDAO orderDAO;
	
	public List<OrderPersistance> findOrders(Integer limit,Integer[] parts){
		 List<OrderPersistance> orders = orderDAO.findOrders(limit, parts);
		 if(orders.size()== 0){
			 throw new OrdersNotFoundException("No orders found given a filter");
		 }else{
		 return orders;
		 }
	}
	@Transactional
	public OrderPersistance addOrder(OrderPersistance order){
		return orderDAO.addOrder(order);
	}

}
