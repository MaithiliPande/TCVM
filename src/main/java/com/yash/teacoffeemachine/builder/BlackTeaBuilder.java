package com.yash.teacoffeemachine.builder;

import org.apache.log4j.Logger;

import com.yash.teacoffeemachine.configuration.BlackTeaConfiguration;
import com.yash.teacoffeemachine.domain.Order;
import com.yash.teacoffeemachine.enumeration.Drink;

public class BlackTeaBuilder extends AbstractDrinkBuilder {
	
	Logger logger = Logger.getLogger(BlackTeaBuilder.class);
	
	public BlackTeaBuilder() {
		setDrinkConfiguration(BlackTeaConfiguration.getDrinkconfiguration());
	}
	
	@Override
	public void prepareDrink(Order order) {
		if(order.getDrink() == Drink.BLACK_TEA) {
			super.prepareDrink(order);
		}else {
			logger.error("Illegal Argument exception: wrong type provided");
			throw new IllegalArgumentException("Wrong Drink type, required "+Drink.BLACK_TEA);
		}
	}
	
	public static IDrinkBuilder getDrinkBuilder() {
		return new BlackTeaBuilder();
	}
	

}
