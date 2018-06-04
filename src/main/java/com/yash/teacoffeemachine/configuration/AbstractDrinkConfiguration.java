package com.yash.teacoffeemachine.configuration;

import java.util.Map;

import org.apache.log4j.Logger;

import com.yash.teacoffeemachine.enumeration.Drink;
import com.yash.teacoffeemachine.enumeration.Ingredient;

public abstract class AbstractDrinkConfiguration implements IDrinkConfiguration {
	
	Logger logger = Logger.getLogger(AbstractDrinkConfiguration.class);
	
	private Map<Ingredient, Double> ingredientConsumption;

	private Map<Ingredient, Double> ingredientWastage;
	
	private double drinkRate;
	private Drink drinkType;

	public AbstractDrinkConfiguration() {
		initDrinkConfig();
	}

	private void initDrinkConfig() {
		configIngredientConsumption();

		configIngredientWastage();

		configDrinkType();

		configDrinkRate();
	}

	public Map<Ingredient, Double> getIngredientConsumption() {
		return ingredientConsumption;
	}

	public void setIngredientConsumption(Map<Ingredient, Double> ingredientConsumption) {
		this.ingredientConsumption = ingredientConsumption;
	}

	public Map<Ingredient, Double> getIngredientWastage() {
		return ingredientWastage;
	}

	public void setIngredientWastage(Map<Ingredient, Double> ingredientWastage) {
		this.ingredientWastage = ingredientWastage;
	}

	public double getDrinkRate() {
		return drinkRate;
	}

	public void setDrinkRate(double drinkRate) {
		this.drinkRate = drinkRate;
	}

	public Drink getDrinkType() {
		return drinkType;
	}

	public void setDrinkType(Drink drinkType) {
		this.drinkType = drinkType;
	}
	
	
}
