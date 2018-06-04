package com.yash.teacoffeemachine.builder;

import java.util.Map;

import org.apache.log4j.Logger;

import com.yash.teacoffeemachine.configuration.AbstractDrinkConfiguration;
import com.yash.teacoffeemachine.configuration.IDrinkConfiguration;
import com.yash.teacoffeemachine.domain.Container;
import com.yash.teacoffeemachine.domain.Order;
import com.yash.teacoffeemachine.enumeration.Ingredient;
import com.yash.teacoffeemachine.exception.ContainerUnderFlowException;
import com.yash.teacoffeemachine.service.ContainerService;
import com.yash.teacoffeemachine.serviceimpl.ContainerServiceImpl;

public class AbstractDrinkBuilder implements IDrinkBuilder {
	
	Logger logger = Logger.getLogger(AbstractDrinkBuilder.class);

	IDrinkConfiguration drinkConfigurer;
	ContainerService containerService = new ContainerServiceImpl();

	@Override
	public void setDrinkConfiguration(IDrinkConfiguration drinkConfigurer) {
		this.drinkConfigurer = drinkConfigurer;
		logger.info("Drink configuration is set");
	}

	@Override
	public void prepareDrink(Order order) {
		AbstractDrinkConfiguration abstractDrinkConfiguration = (AbstractDrinkConfiguration) drinkConfigurer;
		Map<Ingredient, Double> consumption = abstractDrinkConfiguration.getIngredientConsumption();
		Map<Ingredient, Double> wastage = abstractDrinkConfiguration.getIngredientWastage();
		for (Map.Entry<Ingredient, Double> entry : consumption.entrySet()) {
			Container container = containerService.getContainerByIngredient(entry.getKey());
			double quantityWasted = wastage.get(entry.getKey());
			double quantityConsumed = entry.getValue();
			double quantityAvailable = container.getCurrentAvailability();
			int noOfCups = order.getQuantity();
			if ((noOfCups * (quantityConsumed + quantityWasted)) > quantityAvailable) {
				order.setStatus(false);
				throw new ContainerUnderFlowException(entry.getKey() + " insufficient");
			}
			container.setCurrentAvailability(quantityAvailable - (noOfCups * (quantityConsumed + quantityWasted)));
			order.setTotalAmount(abstractDrinkConfiguration.getDrinkRate() * noOfCups);
			System.out.println("Ingredient :" + container.getIngredient() + " Max capacity: "
					+ container.getMaxCapacity() + " Current availability: " + container.getCurrentAvailability());
			containerService.updateContainer(entry.getKey(), container);
		}
		order.setStatus(true);
		logger.info("Drink is prepared");
	}

}
