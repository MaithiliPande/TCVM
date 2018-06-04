package com.yash.teacoffeemachine.serviceimpl;

import java.util.List;

import org.apache.log4j.Logger;

import com.yash.teacoffeemachine.dao.ContainerDAO;
import com.yash.teacoffeemachine.daoimpl.ContainerDAOImpl;
import com.yash.teacoffeemachine.domain.Container;
import com.yash.teacoffeemachine.enumeration.Ingredient;
import com.yash.teacoffeemachine.exception.NullObjectException;
import com.yash.teacoffeemachine.service.ContainerService;

public class ContainerServiceImpl implements ContainerService {
	
	Logger logger = Logger.getLogger(ContainerServiceImpl.class);

	private List<Container> containers;
	private static ContainerServiceImpl containerServiceImpl = new ContainerServiceImpl();
	private ContainerDAO containerDAO;

	public ContainerServiceImpl() {
	}

	public ContainerServiceImpl(ContainerDAO containerDAO) {
		this.containerDAO = containerDAO;
	}

	public static ContainerServiceImpl getInstance() {
		return containerServiceImpl;
	}

	@Override
	public Container getContainerByIngredient(Ingredient ingredient) {
		containerDAO = ContainerDAOImpl.getInstance();
		if (ingredient == null) {
			logger.error("Ingredient cannot be null");
			throw new NullObjectException("Ingredient cannot be null");
		}
		containers = containerDAO.getListOfContainers();
		Container selectedContainer = null;
		for (Container container : containers) {
			if (container.getIngredient() == ingredient) {
				selectedContainer = container;
				break;
			}
		}
		
		return selectedContainer;
	}

	@Override
	public List<Container> getContainers() {
		return containers;
	}

	@Override
	public Container updateContainer(Ingredient ingredient, Container container) {
		if (ingredient == null && container == null) {
			logger.error("Ingredient And Container values cannot null");
			throw new NullObjectException("Ingredient And Container values cannot null");
		}
		Container updatedContainer = containerDAO.updateContainer(ingredient, container);
		return updatedContainer;
	}

	@Override
	public Integer refillContainers() {
		containers = containerDAO.getListOfContainers();
		double diff;
		int rowsAffected = 0;
		for (Container container : containers) {
			diff = container.getMaxCapacity() - container.getCurrentAvailability();
			System.out.println(container.getIngredient() + " : Empty " + diff + " , Available : "
					+ container.getCurrentAvailability() + " , Max Capacity : " + container.getMaxCapacity());
			container.setCurrentAvailability(container.getCurrentAvailability() + diff);
			updateContainer(container.getIngredient(), container);
		}
		rowsAffected = containers.size();
		return rowsAffected;
	}

	@Override
	public Integer containerStatus() {
		containers = containerDAO.getListOfContainers();
		int rowsAffected = 0;
		for (Container container : containers) {
			System.out.println(
					"Ingredient : " + container.getIngredient() + " , Max capacity: " + container.getMaxCapacity()
							+ " , Current availability: " + container.getCurrentAvailability() + "");
		}
		rowsAffected = containers.size();
		return rowsAffected;
	}

}
