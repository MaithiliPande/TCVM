package com.yash.teacoffeemachine.dao;

import java.util.List;

import com.yash.teacoffeemachine.domain.Container;
import com.yash.teacoffeemachine.enumeration.Ingredient;

public interface ContainerDAO {

	public Container updateContainer(Ingredient ingredient, Container container);

	public List<Container> getListOfContainers();

}
