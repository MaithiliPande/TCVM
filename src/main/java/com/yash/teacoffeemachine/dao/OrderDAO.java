package com.yash.teacoffeemachine.dao;

import java.util.List;

import com.yash.teacoffeemachine.domain.Order;
import com.yash.teacoffeemachine.enumeration.Drink;

public interface OrderDAO {
	List<Order> getOrders();

	int insertOrder(Order order);

	List<Order> getOrdersByDrink(Drink drink);

}
