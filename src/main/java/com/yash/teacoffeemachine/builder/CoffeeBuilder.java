package com.yash.teacoffeemachine.builder;

import org.apache.log4j.Logger;

import com.yash.teacoffeemachine.configuration.CoffeeConfiguration;
import com.yash.teacoffeemachine.domain.Order;
import com.yash.teacoffeemachine.enumeration.Drink;

public class CoffeeBuilder extends AbstractDrinkBuilder {
	
	Logger logger = Logger.getLogger(CoffeeBuilder.class);
	
	public CoffeeBuilder() {
		setDrinkConfiguration(CoffeeConfiguration.getDrinkConfiguration());
	}
	
	@Override
	public void prepareDrink(Order order) {
		if(order.getDrink() == Drink.COFFEE) {
			super.prepareDrink(order);
		}else {
			logger.error("Illegal Argument exception: wrong type provided");
			throw new IllegalArgumentException("Wrong Drink Type, required "+Drink.COFFEE);
		}
	}
	
	public static IDrinkBuilder getDrinkBuilder() {
		return new CoffeeBuilder();
	}

}
