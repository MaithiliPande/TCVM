package com.yash.teacoffeemachine.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.yash.teacoffeemachine.daoimpl.ContainerDAOImpl;
import com.yash.teacoffeemachine.domain.Container;
import com.yash.teacoffeemachine.enumeration.Ingredient;
import com.yash.teacoffeemachine.exception.NullObjectException;

public class ContianerDAOImplTest {

	private ContainerDAO containerDAO;

	@Before
	public void init() {
		containerDAO = ContainerDAOImpl.getInstance();
	}

	@Test(expected = NullObjectException.class)
	public void updateContainer_IngredientIsNullAndContainerIsNullGiven_ShouldThrowNullObjectException() {
		Ingredient ingredient = null;
		Container container = null;
		containerDAO.updateContainer(ingredient, container);
	}

	@Test
	public void updateContainer_IngredientAndContainerGiven_ShouldReturnAvailabilityOfSpecifiedIngredient() {
		Ingredient ingredient = Ingredient.COFFEE;
		Container container = new Container(ingredient, 2000.00, 1900.00);
		Container updatedContainer = containerDAO.updateContainer(ingredient, container);
		assertEquals(updatedContainer.getCurrentAvailability(), container.getCurrentAvailability(), 0.00);
	}

	@Test
	public void getListOfContainers_ShouldReturnListOfContainers() {
		List<Container> containers = containerDAO.getListOfContainers();
		int sizeOfContainers = containers.size();
		assertEquals(5, sizeOfContainers);
	}

}
