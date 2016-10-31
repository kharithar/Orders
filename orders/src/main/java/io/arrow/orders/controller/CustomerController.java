package io.arrow.orders.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.arrow.orders.model.CustomerPersistance;
import io.arrow.orders.service.CustomerService;

@RestController
@RequestMapping(path="customers")
public class CustomerController {
	@Autowired
	CustomerService customerService;
	
	@RequestMapping(method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_UTF8_VALUE, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
	public CustomerPersistance addCustomer(@RequestBody CustomerPersistance customer){		
		return customerService.addCustomer(customer);
	}
}
