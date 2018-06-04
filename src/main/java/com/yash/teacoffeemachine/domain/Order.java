package com.yash.teacoffeemachine.domain;

import java.util.Date;

import com.yash.teacoffeemachine.enumeration.Drink;

public class Order {

	private int quantity;
	private Drink drink;
	private Date orderDate = new Date();
	private Boolean status = false;
	private Double totalAmount;

	public Order(int quantity, Drink drink, Boolean status) {
		super();
		this.quantity = quantity;
		this.drink = drink;
		this.status = status;
	}

	public Order(int quantity, Drink drink) {
		super();
		this.quantity = quantity;
		this.drink = drink;
	}

	public Order() {
		super();
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Drink getDrink() {
		return drink;
	}

	public void setDrink(Drink drink) {
		this.drink = drink;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

}
