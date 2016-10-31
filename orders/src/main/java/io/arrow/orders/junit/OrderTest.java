package io.arrow.orders.junit;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import io.arrow.orders.WebConfig;
import io.arrow.orders.model.CustomerPersistance;
import io.arrow.orders.model.OrderPartsPersistance;
import io.arrow.orders.model.OrderPersistance;
import io.arrow.orders.model.PartPersistance;
import io.arrow.orders.model.SupplierPersistance;
import io.arrow.orders.service.OrderService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {WebConfig.class})
@WebAppConfiguration
public class OrderTest {
	
	@Autowired
	OrderService orderService;
	
	@Test
	public void testFindOrders() {
		Integer[] parts = {1001,1002,1003};
		List<OrderPersistance> orders = orderService.findOrders(1, parts);
		assertNotNull(orders.size());	
	}
	
	@Test
	public void testAddOrder() {
		OrderPersistance order = setOrderDetails();
		order = orderService.addOrder(order);
		assertNotNull(order);	
	}

	private OrderPersistance setOrderDetails() {
		OrderPersistance order = new OrderPersistance();
		CustomerPersistance customer = new CustomerPersistance();
		//customer.setId(1);
		customer.setName("Haritha");
		SupplierPersistance supplier = new SupplierPersistance();
		//supplier.setId(201);
		supplier.setName("201 Supplier");
		PartPersistance part = new PartPersistance();
		//part.setId(101);
		part.setDescription("101 description");
		part.setPrice("10");
		part.setSupplier(supplier);
		List<OrderPartsPersistance> orderParts = new ArrayList<OrderPartsPersistance>();
		OrderPartsPersistance orderPart = new OrderPartsPersistance();
		orderPart.setPart(part);
		orderPart.setQuantity(1);
		orderParts.add(orderPart);
		//order.setId(501);
		order.setOrderDate("2016-05-15");
		order.setCustomer(customer);
		return order;
	}
}
