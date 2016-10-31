package io.arrow.orders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.arrow.orders.model.OrderPersistance;
import io.arrow.orders.service.OrderService;

@RestController
@RequestMapping(path="orders")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public List<OrderPersistance> findOrders(@RequestParam("limit")Integer limit,@RequestParam("parts")Integer[] parts){
		return orderService.findOrders(limit, parts);
	}
	
	@RequestMapping(method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public OrderPersistance addOrder(@RequestBody OrderPersistance order){		
		return orderService.addOrder(order);
	}
	

}
