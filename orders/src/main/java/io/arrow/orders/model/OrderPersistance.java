package io.arrow.orders.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
@Entity
@Table(name="orders")
public class OrderPersistance {

	private Integer id;
	private String orderDate;
	private CustomerPersistance customer;
	private List<OrderPartsPersistance> orderParts = new ArrayList<OrderPartsPersistance>();
	
	@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}	
	@NotNull
	@Column(name = "order_date")
	public String getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}
	
	@OneToMany(mappedBy = "order")
	public List<OrderPartsPersistance> getOrderParts() {
		return orderParts;
	}
	public void setOrderParts(List<OrderPartsPersistance> orderParts) {
		this.orderParts = orderParts;
	}
	
	@ManyToOne(targetEntity = CustomerPersistance.class,fetch = FetchType.LAZY)
	@JoinColumn(name="customer_id")
	public CustomerPersistance getCustomer() {
		return customer;
	}
	public void setCustomer(CustomerPersistance customer) {
		this.customer = customer;
	}

	
}
