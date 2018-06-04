package com.yash.teacoffeemachine.builder;

import com.yash.teacoffeemachine.configuration.IDrinkConfiguration;
import com.yash.teacoffeemachine.domain.Order;

public interface IDrinkBuilder {

	void setDrinkConfiguration(IDrinkConfiguration drinkConfigurer);

	void prepareDrink(Order order);
	
}
