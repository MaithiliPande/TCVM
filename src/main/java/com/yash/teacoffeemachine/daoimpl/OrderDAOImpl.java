package com.yash.teacoffeemachine.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.yash.teacoffeemachine.dao.OrderDAO;
import com.yash.teacoffeemachine.domain.Order;
import com.yash.teacoffeemachine.enumeration.Drink;
import com.yash.teacoffeemachine.exception.EmptyListException;
import com.yash.teacoffeemachine.exception.NullObjectException;
import com.yash.teacoffeemachine.util.JsonUtil;

public class OrderDAOImpl implements OrderDAO {
	
	Logger logger = Logger.getLogger(OrderDAOImpl.class);

	@Override
	public List<Order> getOrders() {
		List<Order> orderList = JsonUtil.readOrderJSONFromFile();
		if(orderList.isEmpty()) {
			logger.error("Order List is empty");
			throw new EmptyListException("Order List is empty");
		}
		return orderList;
	}

	@Override
	public int insertOrder(Order order) {
		int rowsAffected = 0;
		if(order == null) {
			logger.error("Order is null");
			throw new NullObjectException("Order cannot be null");
		}
		
		List<Order> orders = getOrders();
		orders.add(order);
		
		JsonUtil.writeJSONToFile(orders);
		rowsAffected = 1;
		logger.info("Order is inserted in file");
		return rowsAffected;
	}

	@Override
	public List<Order> getOrdersByDrink(Drink drink) {
		List<Order> selectedOrders = new ArrayList<>();
		List<Order> orders = getOrders();
		if(orders.isEmpty()) {
			logger.error("Order List is empty");
			throw new EmptyListException("Order List is empty");
		}
		if(orders.size()>0 || orders != null) {
			for (Order order : orders) {
				if(order.getDrink() == drink) {
					selectedOrders.add(order);
				}
			}
		}
		return selectedOrders;
	}
	

}
