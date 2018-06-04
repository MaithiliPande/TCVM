package com.yash.teacoffeemachine.serviceimpl;

import java.util.List;

import org.apache.log4j.Logger;

import com.yash.teacoffeemachine.builder.BlackCoffeeBuilder;
import com.yash.teacoffeemachine.builder.BlackTeaBuilder;
import com.yash.teacoffeemachine.builder.CoffeeBuilder;
import com.yash.teacoffeemachine.builder.IDrinkBuilder;
import com.yash.teacoffeemachine.builder.TeaBuilder;
import com.yash.teacoffeemachine.dao.OrderDAO;
import com.yash.teacoffeemachine.domain.Order;
import com.yash.teacoffeemachine.enumeration.Drink;
import com.yash.teacoffeemachine.exception.NullObjectException;
import com.yash.teacoffeemachine.service.OrderService;

public class OrderServiceImpl implements OrderService {
	
	Logger logger = Logger.getLogger(OrderServiceImpl.class);
	
	private OrderDAO orderDAO;
	
	public OrderServiceImpl(OrderDAO orderDAO) {
		this.orderDAO = orderDAO;
	}

	@Override
	public List<Order> getOrders() {
		List<Order> orders = orderDAO.getOrders();
		if(orders == null) {
			logger.error("List of order is null");
			throw new NullObjectException("List of order is null");
		}
		return orders;
	}

	@Override
	public List<Order> getOrdersByDrink(Drink drink) {
		List<Order> orderList = orderDAO.getOrdersByDrink(drink);
		
		if(orderList == null) {
			logger.error("List of order is null");
			throw new NullObjectException("Order list is null");
		}
		return orderList;
	}

	@Override
	public int addOrder(Order order) {
		IDrinkBuilder drinkBuilder;
		int rowsAffected = 0;
		if(order == null) {
			logger.error("order is null");
			throw new NullObjectException("Order object is null");
		}
		switch (order.getDrink()) {
		case TEA:
			drinkBuilder = TeaBuilder.getDrinkBuilder();
			drinkBuilder.prepareDrink(order);
			break;
		case COFFEE:
			drinkBuilder = CoffeeBuilder.getDrinkBuilder();
			drinkBuilder.prepareDrink(order);
			break;
		case BLACK_TEA:
			drinkBuilder = BlackTeaBuilder.getDrinkBuilder();
			drinkBuilder.prepareDrink(order);
			break;
		case BLACK_COFFEE:
			drinkBuilder = BlackCoffeeBuilder.getDrinkBuilder();
			drinkBuilder.prepareDrink(order);
			break;
		default:
			System.out.println("Wrong choice");
			break;
		}
		rowsAffected = orderDAO.insertOrder(order);
		return rowsAffected;
	}

}
