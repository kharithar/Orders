package io.arrow.orders.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import io.arrow.orders.dao.CustomerDAO;
import io.arrow.orders.model.CustomerPersistance;
@Service
public class CustomerService {
	@Autowired
	CustomerDAO customerDAO;
	@Transactional
	public CustomerPersistance addCustomer(CustomerPersistance customer){
		return customerDAO.addCustomer(customer);
	}
}
