package com.dronebuzzers.parts.repositories.order;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "orders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "order_id")
	private long id;

	@OneToMany(mappedBy = "order")
	private Set<OrderLine> orderLines;	
	
	private String dbOrderNumber;

	private String clientId;
	
	private String clientReference;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Set<OrderLine> getOrderLines() {
		return orderLines;
	}
	public void setOrderLines(Set<OrderLine> orderLines) {
		this.orderLines = orderLines;
	}
	public String getDbOrderNumber() {
		return dbOrderNumber;
	}
	public void setDbOrderNumber(String orderReference) {
		this.dbOrderNumber = orderReference;
	}
	public String getClientId() {
		return clientId;
	}
	public void setClientId(String clientId) {
		this.clientId = clientId;
	}
	public String getClientReference() {
		return clientReference;
	}
	public void setClientReference(String clientReference) {
		this.clientReference = clientReference;
	}

	

}
