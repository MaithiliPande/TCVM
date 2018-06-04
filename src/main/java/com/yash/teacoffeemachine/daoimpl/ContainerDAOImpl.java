package com.yash.teacoffeemachine.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.yash.teacoffeemachine.dao.ContainerDAO;
import com.yash.teacoffeemachine.domain.Container;
import com.yash.teacoffeemachine.enumeration.Ingredient;
import com.yash.teacoffeemachine.exception.NullObjectException;
import com.yash.teacoffeemachine.util.JsonUtil;

public class ContainerDAOImpl implements ContainerDAO {
	
	Logger logger = Logger.getLogger(ContainerDAOImpl.class) ;

	private List<Container> containers;
	private static ContainerDAOImpl containerDAOImpl = new ContainerDAOImpl();
	private JsonUtil jsonUtil = new JsonUtil();

	public ContainerDAOImpl() {
		containers = new ArrayList<Container>();
		containers.add(new Container(Ingredient.COFFEE, 2000, 2000));
		containers.add(new Container(Ingredient.MILK, 10000, 10000));
		containers.add(new Container(Ingredient.SUGAR, 8000, 8000));
		containers.add(new Container(Ingredient.TEA, 2000, 2000));
		containers.add(new Container(Ingredient.WATER, 15000, 15000));
		saveContainers(containers);
	}

	private void saveContainers(List<Container> containers) {
		jsonUtil.writeObjectToJson(containers);
	
	}

	public static ContainerDAOImpl getInstance() {
		return containerDAOImpl;
	}

	@Override
	public Container getContainer(Ingredient ingredient) {
		if (ingredient == null) {
			throw new NullObjectException("Ingredient Field can not be null");
		}

		return null;
	}

	@Override
	public Container updateContainer(Ingredient ingredient, Container givenContainer) {
		if (ingredient == null && givenContainer == null) {
			logger.error("Ingredient and givenContianer are null");
			throw new NullObjectException("Ingredient And Container values cannot null");
		}

		for (Container container : containers) {
			if (container.getIngredient() == ingredient) {
				containers.set(containers.indexOf(container), givenContainer);
				break;
			}
		}

		saveContainers(containers);
		
		return givenContainer;
		
	}

	@Override
	public List<Container> getListOfContainers() {
		containers = jsonUtil.readObjectFromJson();
		return containers;
	}

}
