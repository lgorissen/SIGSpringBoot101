package com.dronebuzzers.parts.repositories.part;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Part {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String partId;
	private String category;
	private String type;
	private String name;
	private double unitPrice;
	private String currency;

	@Override
	public String toString() {
		return "ID: " + id + " PartId: " + partId + " Category: " + category + " Type: " + type + " Name: " + name + " UnitPrice: " + unitPrice
				+ " Currency: " + currency;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getPartId() {
		return partId;
	}

	public void setPartId(String partId) {
		this.partId = partId;
	}

}