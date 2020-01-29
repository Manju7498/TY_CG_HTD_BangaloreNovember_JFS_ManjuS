package com.cg.forestrymanagementjpa.controller;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.forestrymanagementjpa.bean.UserBean;
import com.cg.forestrymanagementjpa.factory.UserFactory;
import com.cg.forestrymanagementjpa.main.MainForestry;
import com.cg.forestrymanagementjpa.service.UserService;
import com.cg.forestrymanagementjpa.validations.Validations;

public class UserController {
	Validations validations = new Validations();
	Scanner scanner = new Scanner(System.in);
	UserService services = UserFactory.instanceofUserServices();
	UserBean userBean = new UserBean();

	public void user() {
		while (true) {
			System.out.println("Enter 1 to add user");
			System.out.println("Enter 2 to delete user");
			System.out.println("Enter 3 to return to home");
			System.out.println("Enter 4 to logout(admin)");
			String choice = scanner.next();
			Pattern pattern = Pattern.compile("^[1-4]{1}$");
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
				addUser();
				break;
			case 2:
				deleteUser();
				break;
			case 3:
				MainForestry.home();
				break;
			case 4:
				System.out.println("Thank You For Using Our Services...Visit Again!!!!!!!!");
				MainForestry.home();
				break;
			default:
				break;
			}
		}
	}

	public void addUser() {
		try {
			System.out.println("Enter email(Ex:john@gmail.com)");
			String email = scanner.next();
			boolean isValidEmail = validations.emailValidation(email);
			while (!isValidEmail) {
				System.err.println("Please enter email again(Ex:john@gmail.com)");
				email = scanner.next();
				if (validations.emailValidation(email)) {
					break;
				}
			}
			userBean.setEmail(email);
			System.out.println("Enter Password(includes A,a,1,@,atleast 8 characters)");
			String password = scanner.next();
			boolean isValidPassword = validations.passwordValidation(password);
			while (!isValidPassword) {
				System.err.println("Please enter password again(includes A,a,1,@,atleast 8 characters)");
				password = scanner.next();
				if (validations.passwordValidation(password)) {
					break;
				}
			}
			userBean.setPassword(password);
			System.out.println("Enter Role");
			String role = scanner.next();
			boolean isValidRole = validations.nameValidation(role);
			while (!isValidRole) {
				System.err.println("Please enter role again");
				role = scanner.next();
				if (validations.nameValidation(role)) {
					break;
				}
			}
			userBean.setLoginType(role);
			boolean check = services.addUser(userBean);
			if (check) {
				System.out.println(userBean.getLoginType() + " registered successfully");
			} else {
				System.err.println(userBean.getLoginType() + " details already exists");
			}
		} catch (Exception e) {
			System.err.println(userBean.getLoginType() + " cannot be registered..Please try again!!!");
		}
	}

	public void deleteUser() {
		System.out.println("Enter email to delete user data");
		try {
			String email = scanner.next();
			if (services.deleteUser(email)) {
				System.out.println(email + " deleted");
			} else {
				System.err.println(email + " not found to delete");
			}
		} catch (Exception e) {
			System.err.println("Please........Try Again");
		}
	}

	@SuppressWarnings("null")
	public void login() {
		try {
			System.out.println("Enter email(Ex:john@gmail.com)");
			String email = scanner.next();
			boolean isValidEmail = validations.emailValidation(email);
			while (!isValidEmail) {
				System.err.println("Please enter email again(Ex:john@gmail.com)");
				email = scanner.next();
				if (validations.emailValidation(email)) {
					break;
				}
			}
			System.out.println("Enter Password(includes A,a,1,@,atleast 8 characters)");
			String password = scanner.next();
			boolean isValidPassword = validations.passwordValidation(password);
			while (!isValidPassword) {
				System.err.println("Please enter password again(includes A,a,1,@,atleast 8 characters)");
				password = scanner.next();
				if (validations.passwordValidation(password)) {
					break;
				}
			}
			UserBean userBean1 = services.login(email, password);
			if(userBean1!=null) {
				System.out.println("Welcome "+userBean1.getLoginType()+"...Logged Successfully");
				if(userBean1.getLoginType().equalsIgnoreCase("admin")) {
					user();
				}else if(userBean1.getLoginType().equalsIgnoreCase("client")) {
					MainForestry.operations1();
				}else if(userBean1.getLoginType().equalsIgnoreCase("scheduler")) {
					MainForestry.operations2();
				}
			} else{
				System.out.println(userBean1.getEmail()+" is not registered");
			}
		} catch (Exception e) {
			System.err.println("Please register first!!!!");
		}

	}
}
