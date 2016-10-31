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
@Table(name="parts")
public class PartPersistance {

	private Integer id;
	private String name;
	private String description;
	private String price;
	private SupplierPersistance supplier;
	private List<OrderPartsPersistance> orderParts = new ArrayList<OrderPartsPersistance>();

	@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "part_id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}	
	@ManyToOne(targetEntity = SupplierPersistance.class,fetch = FetchType.LAZY)
	@JoinColumn(name="supplier_id")
	public SupplierPersistance getSupplier() {
		return supplier;
	}
	public void setSupplier(SupplierPersistance supplier) {
		this.supplier = supplier;
	}	
	@OneToMany(mappedBy = "part")
	public List<OrderPartsPersistance> getOrderParts() {
		return orderParts;
	}
	public void setOrderParts(List<OrderPartsPersistance> orderParts) {
		this.orderParts = orderParts;
	}
}
