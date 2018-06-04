package com.yash.teacoffeemachine.configuration;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.yash.teacoffeemachine.enumeration.Drink;
import com.yash.teacoffeemachine.enumeration.Ingredient;

public class BlackTeaConfiguration extends AbstractDrinkConfiguration {
	
	Logger logger = Logger.getLogger(BlackTeaConfiguration.class);
	
	private static IDrinkConfiguration drinkConfigurer;
	public static final double TEA_CONSUMPTION = 3;
	public static final double WATER_CONSUMPTION = 100;
	public static final double SUGAR_CONSUMPTION = 15;
	
	public static final double TEA_WASTAGE = 0;
	public static final double WATER_WASTAGE = 12;
	public static final double SUGAR_WASTAGE = 2;
	
	public static final double RATE = 15;
	
	static{
		drinkConfigurer = new BlackTeaConfiguration();
	}
	
	public static IDrinkConfiguration getDrinkconfiguration() {
		return drinkConfigurer;
	}

	@Override
	public void configIngredientConsumption() {
		Map<Ingredient, Double> ingredientConsumption = new HashMap<>();
		ingredientConsumption.put(Ingredient.TEA, TEA_CONSUMPTION);
		ingredientConsumption.put(Ingredient.WATER, WATER_CONSUMPTION);
		ingredientConsumption.put(Ingredient.SUGAR, SUGAR_CONSUMPTION);
		setIngredientConsumption(ingredientConsumption);
		logger.info("Ingredient consumption is set for Black Tea");
	}

	@Override
	public void configIngredientWastage() {
		Map<Ingredient, Double> ingredientWastage = new HashMap<>();
		ingredientWastage.put(Ingredient.TEA, TEA_WASTAGE);
		ingredientWastage.put(Ingredient.WATER, WATER_WASTAGE);
		ingredientWastage.put(Ingredient.SUGAR, SUGAR_WASTAGE);
		setIngredientWastage(ingredientWastage);
		logger.info("Ingredient wastage is set for Black Tea");
	}

	@Override
	public void configDrinkType() {
		setDrinkType(Drink.BLACK_TEA);
		logger.info("Drink type is set for Black Tea");
	}

	@Override
	public void configDrinkRate() {
		setDrinkRate(RATE);
		logger.info("Rate is set for Black Tea");
	}

}
