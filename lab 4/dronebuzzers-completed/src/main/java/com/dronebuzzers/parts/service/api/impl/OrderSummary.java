package com.dronebuzzers.parts.service.api.impl;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.dronebuzzers.parts.service.api.impl.PartsDAO;

public class OrderSummary {
	private String dbOrderNumber;
	private String clientId;
	private String clientReference;
	private double totalAmount;
	private List<OrderSummaryLine> orderSummaryLines;

	public OrderSummary() {
		super();
		dbOrderNumber = "";
		clientId = "";
		clientReference = "";
		totalAmount = 0.0;
		orderSummaryLines = new ArrayList<OrderSummaryLine>();
	}

	public OrderSummary(String dbOrderNumber, String clientId, String clientReference, double totalAmount,
			List<OrderSummaryLine> orderSummaryLines) {
		this.dbOrderNumber = dbOrderNumber;
		this.clientId = clientId;
		this.clientReference = clientReference;
		this.totalAmount = totalAmount;
		this.orderSummaryLines = orderSummaryLines;
	}

	public OrderSummary(Order order, PartsDAO partsDAO) {

		super();
		OrderLine[] orderLines = order.getOrderLines();

		double totalOrderAmount = 0.0;

		List<OrderSummaryLine> orderSummaryLines = new ArrayList<OrderSummaryLine>();

		for (int i = 0; i < orderLines.length; i++) {
			if (orderLines[i].getCount() > 0) {
				totalOrderAmount = totalOrderAmount
						+ partsDAO.getAmount(orderLines[i].getId(), orderLines[i].getCount());
				orderSummaryLines
						.add(new OrderSummaryLine(partsDAO.getPart(orderLines[i].getId()), orderLines[i].getCount()));

			}
		}

		DecimalFormat twoDForm = new DecimalFormat("#.##");
		totalOrderAmount = Double.valueOf(twoDForm.format(totalOrderAmount));

		this.setTotalAmount(totalOrderAmount);
		this.setClientId(order.getClientId());
		this.setClientReference(order.getClientReference());
		this.setDbOrderNumber();
		this.setOrderSummaryLines(orderSummaryLines);

	}

	public String getDbOrderNumber() {
		return this.dbOrderNumber;
	}

	public String getClientId() {
		return this.clientId;
	}

	public String getClientReference() {
		return this.clientReference;
	}

	public double getTotalAmount() {
		return this.totalAmount;
	}

	public List<OrderSummaryLine> getOrderSummaryLines() {
		return this.orderSummaryLines;
	}

	public void setOrderSummaryLines(List<OrderSummaryLine> orderSummaryLines) {
		this.orderSummaryLines = orderSummaryLines;
		return;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
		return;
	}

	public void setClientReference(String clientReference) {
		this.clientReference = clientReference;
		return;
	}

	public void setTotalAmount(double totalAmount) {
		this.totalAmount = totalAmount;
		return;
	}

	public void setDbOrderNumber() {

		Random rand = new Random();
		String randomNumber = "00" + rand.nextInt(1000000);
		dbOrderNumber = "DB-" + randomNumber.toString();
		return;
	}

	@Override
	public String toString() {
		return "Db Order Number: " + dbOrderNumber + " Client Id: " + clientId + " Client Reference: " + clientReference
				+ " Total Amount: " + totalAmount + " Parts count: " + orderSummaryLines.size();
	}

}
