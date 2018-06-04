package com.yash.teacoffeemachine.builder;

import com.yash.teacoffeemachine.configuration.TeaConfiguration;
import com.yash.teacoffeemachine.domain.Order;
import com.yash.teacoffeemachine.enumeration.Drink;

public class TeaBuilder extends AbstractDrinkBuilder {


	public TeaBuilder() {
		setDrinkConfiguration(TeaConfiguration.getDrinkConfigurer());
	}

	@Override
	public void prepareDrink(Order order) {
		if (order.getDrink() == Drink.TEA) {
			super.prepareDrink(order);
		} else {

			throw new IllegalArgumentException("Wrong Drink Type, required " + Drink.TEA);
		}
	}

	public static IDrinkBuilder getDrinkBuilder() {
		return new TeaBuilder();
	}

}
