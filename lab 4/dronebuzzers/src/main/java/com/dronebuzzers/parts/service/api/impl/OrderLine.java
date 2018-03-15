package com.dronebuzzers.parts.service.api.impl;

public class OrderLine {

	private String id;
	private int count;

	public OrderLine() {
		super();
		id = "";
		count = 0;
	}

	public OrderLine(String id, int count) {
		this.id = id;
		this.count = count;
	}

	public String getId() {
		return this.id;
	}

	public int getCount() {
		return this.count;
	}

	@Override
	public String toString() {
		return "ID: " + id + " Count: " + count;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setCount(int count) {
		this.count = count;
	}

}
