package com.yash.teacoffeemachine.dao;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.yash.teacoffeemachine.daoimpl.OrderDAOImpl;
import com.yash.teacoffeemachine.domain.Order;
import com.yash.teacoffeemachine.enumeration.Drink;
import com.yash.teacoffeemachine.exception.NullObjectException;

public class OrderDAOImplTest {


	
	private OrderDAO orderDAO;

	@Before
	public void setUp() {
		orderDAO = new OrderDAOImpl();
	}

	@Test
	public void insertOrder_ShouldReturnOne_WhenOrderObjectIsGiven() {
		Order order = new Order(5, Drink.TEA, true);
		assertEquals(1, orderDAO.insertOrder(order));
	}

	@Test
	public void getOrders_shouldReturnSizeOfOrdersList_WhenListOfOrderObjectAreInJSONFile() {
		
		assertEquals(1, orderDAO.getOrders().size());
	}

	@Test(expected = NullObjectException.class)
	public void insertOrder_shouldThrowException_WhenOrderObjectGivenIsNull() {
		Order order = null;
		assertEquals(1, orderDAO.insertOrder(order));
	}

	@Test
	public void getOrdersByDrink_ShouldReturnSizeOfOrderList_WhenDrinkTypeIsGivenAndJSONFileHasOrdersOfGivenDrinkType() {
		assertEquals(1, orderDAO.getOrdersByDrink(Drink.TEA).size());
	}

	@Test
	public void getOrdersByDrink_ShouldReturnSizeOfOrderListAsZero_WhenDrinkTypeIsGivenAndJSONFileDoesntHasOrdersOfGivenDrinkType() {
		assertEquals(0, orderDAO.getOrdersByDrink(Drink.BLACK_COFFEE).size());
	}

}
