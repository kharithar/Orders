package io.arrow.orders.dao;

import io.arrow.orders.model.CustomerPersistance;

public interface ICustomerDAO {
	public CustomerPersistance addCustomer(CustomerPersistance customer);
}
