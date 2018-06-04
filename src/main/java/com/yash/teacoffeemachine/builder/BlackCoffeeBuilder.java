package com.yash.teacoffeemachine.builder;

import org.apache.log4j.Logger;

import com.yash.teacoffeemachine.configuration.BlackCoffeeCofiguration;
import com.yash.teacoffeemachine.domain.Order;
import com.yash.teacoffeemachine.enumeration.Drink;

public class BlackCoffeeBuilder extends AbstractDrinkBuilder {
	
	Logger logger = Logger.getLogger(BlackCoffeeBuilder.class);
	public BlackCoffeeBuilder() {
		setDrinkConfiguration(BlackCoffeeCofiguration.getDrinkConfigurer());
	}
	
	@Override
	public void prepareDrink(Order order) {
		if(order.getDrink() == Drink.BLACK_COFFEE) {
			super.prepareDrink(order);
		}else {
			logger.error("Illegal Argument exception: wrong type provided");
			throw new IllegalArgumentException("Wrong drink type, required "+Drink.BLACK_COFFEE);
		}
	}
	
	public static IDrinkBuilder getDrinkBuilder() {
		return new BlackCoffeeBuilder();
	}

}
