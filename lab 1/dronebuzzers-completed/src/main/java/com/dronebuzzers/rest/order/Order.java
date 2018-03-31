package com.dronebuzzers.rest.order;

public class Order {
	private String clientId;
	private String clientReference;
	private OrderLine[] orderLines;

	public Order() {
		super();
		clientId = "";
		clientReference = "";
		orderLines = new OrderLine[0];
	}

	public Order(String clientId, String clientReference, OrderLine[] orderLines) {
		this.clientId = clientId;
		this.clientReference = clientReference;
		this.orderLines = orderLines;
	}

	public String getClientId() {
		return this.clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
		return;
	}

	public String getClientReference() {
		return this.clientReference;
	}

	public void setClientReference(String clientReference) {
		this.clientReference = clientReference;
		return;
	}

	public OrderLine[] getOrderLines() {
		return this.orderLines;
	}

	@Override
	public String toString() {
		return " Client Reference: " + clientReference + " OrderLines count: " + orderLines.length;
	}

}