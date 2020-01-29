package com.cg.forestrymanagementcollections.main;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.forestrymanagementcollections.controller.ContractController;
import com.cg.forestrymanagementcollections.controller.CustomerController;
import com.cg.forestrymanagementcollections.controller.HaulierController;
import com.cg.forestrymanagementcollections.controller.OrderController;
import com.cg.forestrymanagementcollections.controller.ProductController;
import com.cg.forestrymanagementcollections.controller.UserController;
import com.cg.forestrymanagementcollections.validations.Validations;

public class MainForestry {
	static Scanner scanner = new Scanner(System.in);
	static Validations validations = new Validations();

	public static void main(String[] args) {
		home();
	}

	public static void home() {
		UserController user = new UserController();
		while (true) {
			System.out.println("***********FORESTRY MANAGEMENT SYSTEM*************");
			System.out.println("Enter 1 to register");
			System.out.println("Enter 2 to login");
			System.out.println("Enter 3 for client & Scheduler");
			String choice = scanner.next();
			Pattern pattern = Pattern.compile("^[1234]{1}$");
			boolean isValidChoice = true;
			do {
				Matcher matcher = pattern.matcher(choice);
				if (matcher.matches()) {
					isValidChoice = false;
				} else {
					System.err.println("Please Enter valid choice");
					choice = scanner.next();
				}
			} while (isValidChoice);
			switch (Integer.parseInt(choice)) {
			case 1:
				user.addAdmin();
				break;
			case 2:
				user.signIn();
				break;
			case 3:
				user.login();
				break;
			default:
				break;

			}
		}
	}

	public static void operations1() {
		while (true) {
			System.out.println("Press 1 for contract info");
			System.out.println("press 2  for customer info");
			System.out.println("press 3  for product info");
			System.out.println("press 4  for order info");
			System.out.println("press 5 to return back");
			String choice = scanner.next();
			Pattern pattern = Pattern.compile("^[1-5]{1}$");
			boolean isValidChoice = true;
			do {
				Matcher matcher = pattern.matcher(choice);
				if (matcher.matches()) {
					isValidChoice = false;
				} else {
					System.err.println("Please Enter valid choice");
					choice = scanner.next();
				}
			} while (isValidChoice);
			switch (Integer.parseInt(choice)) {
			case 1:
				ContractController contractController = new ContractController();
				contractController.contractor();
				break;
			case 2:
				CustomerController customerController = new CustomerController();
				customerController.customer();
				break;
			case 3:
				ProductController productController = new ProductController();
				productController.product();
				break;
			case 4:
				OrderController orderController = new OrderController();
				orderController.order();
				break;
			case 5:
				MainForestry.home();
			default:
				break;
			}
		}
	}

	public static void operations2() {
		while (true) {
			System.out.println("Press 1 for scheduler info");
			System.out.println("press 2 to return back to home");
			String choice = scanner.next();
			Pattern pattern = Pattern.compile("^[12]{1}$");
			boolean isValidChoice = true;
			do {
				Matcher matcher = pattern.matcher(choice);
				if (matcher.matches()) {
					isValidChoice = false;
				} else {
					System.err.println("Please Enter valid choice");
					choice = scanner.next();
				}
			} while (isValidChoice);
			switch (Integer.parseInt(choice)) {
			case 1:
				HaulierController haulierController = new HaulierController();
				haulierController.haulier();
				break;
			case 2:
				MainForestry.home();
				break;
			default:
				break;
			}
		}
	}
}
