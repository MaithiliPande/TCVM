package com.yash.teacoffeemachine.main;

import java.util.Scanner;


import com.yash.teacoffeemachine.dao.ContainerDAO;
import com.yash.teacoffeemachine.dao.OrderDAO;
import com.yash.teacoffeemachine.daoimpl.ContainerDAOImpl;
import com.yash.teacoffeemachine.daoimpl.OrderDAOImpl;
import com.yash.teacoffeemachine.domain.Order;
import com.yash.teacoffeemachine.enumeration.Drink;
import com.yash.teacoffeemachine.service.ContainerService;
import com.yash.teacoffeemachine.service.OrderService;
import com.yash.teacoffeemachine.serviceimpl.ContainerServiceImpl;
import com.yash.teacoffeemachine.serviceimpl.OrderServiceImpl;
import com.yash.teacoffeemachine.util.MenuUtil;

public class Startup {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		ContainerDAO containerDAO = ContainerDAOImpl.getInstance();
		ContainerService containerService = new ContainerServiceImpl(containerDAO);
		OrderDAO orderDAO = new OrderDAOImpl();
		OrderService orderService = new OrderServiceImpl(orderDAO);
		int choice;
		int noOfCups;
		String continueChoice;
		do {
			MenuUtil menuUtil = new MenuUtil();
			menuUtil.readFile("menu.txt");
			choice = scanner.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter no. of Cups");
				noOfCups = scanner.nextInt();
				orderService.addOrder(new Order(noOfCups, Drink.TEA));
				break;
			case 2:
				System.out.println("Enter no. of Cups");
				noOfCups = scanner.nextInt();
				orderService.addOrder(new Order(noOfCups, Drink.COFFEE));
				break;
			case 3:
				System.out.println("Enter no. of Cups");
				noOfCups = scanner.nextInt();
				orderService.addOrder(new Order(noOfCups, Drink.BLACK_TEA));
				break;
			case 4:
				System.out.println("Enter no. of Cups");
				noOfCups = scanner.nextInt();
				orderService.addOrder(new Order(noOfCups, Drink.BLACK_COFFEE));
				break;
			case 5:
				containerService.refillContainers();
				break;
			case 6:
				containerService.containerStatus();
				break;
			case 7:
				System.exit(0);
				break;
			}
			System.out.println("Do you want to continue?(yes/no)");
			continueChoice = scanner.next();
		} while (continueChoice.equalsIgnoreCase("yes"));
		scanner.close();
	}

}
