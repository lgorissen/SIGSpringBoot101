package com.dronebuzzers.parts.repositories.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "orderlines")
public class OrderLine {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "orderline_id")
	private long id;

	@ManyToOne
	@JoinColumn (name="order_id")
	@JsonBackReference
	private Order order;
	
    private int count;
    private String partId;
    private String dbOrderNumber;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
    public String getPartId() {
		return partId;
	}
	public void setPartId(String partId) {
		this.partId = partId;
	}
	public String getDbOrderNumber() {
		return dbOrderNumber;
	}
	public void setDbOrderNumber(String dbOrderNumber) {
		this.dbOrderNumber = dbOrderNumber;
	}
}
