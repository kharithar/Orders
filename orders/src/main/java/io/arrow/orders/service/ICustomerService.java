package io.arrow.orders.service;

import io.arrow.orders.model.CustomerPersistance;

public interface ICustomerService {
	public CustomerPersistance addCustomer(CustomerPersistance customer);
}
