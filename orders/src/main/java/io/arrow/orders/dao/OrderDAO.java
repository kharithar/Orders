package io.arrow.orders.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import io.arrow.orders.model.OrderPersistance;
@Repository
public class OrderDAO {
	
	@PersistenceContext
	private EntityManager em;
	
	public List<OrderPersistance> findOrders(Integer limit,Integer[] parts){
		String sql = "from orders join orders_parts_xref where part_id in (:partsParam)";
		Query query = em.createQuery(sql);
		query.setParameter("partsParam", parts);
		query.setMaxResults(limit);
		List<OrderPersistance> orders = query.getResultList();
		return orders;		
	}
	
	public OrderPersistance addOrder(OrderPersistance order){
		em.persist(order);
		return order;
	}

}
