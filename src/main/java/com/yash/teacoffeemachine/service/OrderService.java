package com.yash.teacoffeemachine.service;

import java.util.List;

import com.yash.teacoffeemachine.domain.Order;
import com.yash.teacoffeemachine.enumeration.Drink;

public interface OrderService {
	List<Order> getOrders() ;

	List<Order> getOrdersByDrink(Drink drink);

	int addOrder(Order order);

}
