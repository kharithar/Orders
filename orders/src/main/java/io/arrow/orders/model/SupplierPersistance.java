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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
@Entity
@Table(name="suppliers")
public class SupplierPersistance {

	private Integer id;
	private String name;
	private List<PartPersistance> parts = new ArrayList<PartPersistance>();
	
	@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "supplier_id")
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
	@OneToMany(targetEntity = PartPersistance.class,fetch = FetchType.LAZY)
	@JoinColumn(name="supplier_id",insertable = false,updatable = false)
	@LazyCollection(LazyCollectionOption.FALSE)
	public List<PartPersistance> getParts() {
		return parts;
	}
	public void setParts(List<PartPersistance> parts) {
		this.parts = parts;
	}
	
}
