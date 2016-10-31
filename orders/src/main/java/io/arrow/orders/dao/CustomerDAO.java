package io.arrow.orders.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import io.arrow.orders.model.CustomerPersistance;
@Repository
public class CustomerDAO {
	@PersistenceContext
	private EntityManager em;
	
	public CustomerPersistance addCustomer(CustomerPersistance customer){
		em.persist(customer);
		return customer;
	}
}
