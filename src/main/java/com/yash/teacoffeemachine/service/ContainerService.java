package com.yash.teacoffeemachine.service;

import java.util.List;

import com.yash.teacoffeemachine.domain.Container;
import com.yash.teacoffeemachine.enumeration.Ingredient;

public interface ContainerService {

	Container getContainerByIngredient(Ingredient ingredient);

	List<Container> getContainers();

	Container updateContainer(Ingredient ingredient, Container container);

	Integer refillContainers();

	Integer containerStatus();

}
