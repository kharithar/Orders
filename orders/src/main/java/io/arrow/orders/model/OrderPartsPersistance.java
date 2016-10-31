package io.arrow.orders.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name ="orders_parts_xref")
public class OrderPartsPersistance {
	private Integer id;
	private OrderPersistance order;
	private PartPersistance part;
	private int quantity;
	
	@NotNull
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_part_id")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id")
	public OrderPersistance getOrder() {
		return order;
	}
	public void setOrder(OrderPersistance order) {
		this.order = order;
	}
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "part_id")
	public PartPersistance getPart() {
		return part;
	}
	public void setPart(PartPersistance part) {
		this.part = part;
	}	
	@NotNull
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
		
}
