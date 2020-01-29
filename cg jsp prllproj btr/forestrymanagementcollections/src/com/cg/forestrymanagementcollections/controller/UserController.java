package com.cg.forestrymanagementcollections.controller;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.forestrymanagementcollections.bean.AdminBean;
import com.cg.forestrymanagementcollections.bean.UserBean;
import com.cg.forestrymanagementcollections.factory.UserFactory;
import com.cg.forestrymanagementcollections.main.MainForestry;
import com.cg.forestrymanagementcollections.service.UserService;
import com.cg.forestrymanagementcollections.validations.Validations;

public class UserController {
	Validations validations = new Validations();
	Scanner scanner = new Scanner(System.in);
	UserService services = UserFactory.instanceofUserServices();
	UserBean userBean = new UserBean();
	AdminBean adminBean=new AdminBean();

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
			System.out.println("Enter Role(Client or Scheduler)");
			String role = scanner.next();
			boolean isValidRole = validations.roleValidation(role);
			while (!isValidRole) {
				System.err.println("Please enter  valid role again(Client or Scheduler)");
				role = scanner.next();
				if (validations.roleValidation(role)) {
					break;
				}
			}
			userBean.setRole(role);
			boolean check = services.addUser(email, userBean);
			if (check) {
				System.out.println(userBean.getRole() + " registered successfully");
			} else {
				System.err.println(userBean.getRole() + " already exists");
			}
		} catch (Exception e) {
			System.err.println(userBean.getRole() + " cannot be registered..Please try again!!!");
		}
	}
	public void addAdmin() {
		
		try {
			System.out.println("Enter name");
			String name= scanner.next();
			boolean isValidName = validations.nameValidation(name);
			while (!isValidName) {
				System.err.println("Please enter name again(Ex:john@gmail.com)");
				name = scanner.next();
				if (validations.nameValidation(name)) {
					break;
				}
			}
			adminBean.setName(name);
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
			adminBean.setEmail(email);
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
			adminBean.setPassword(password);
			System.out.println("Enter Phone Number(only 10 digit number)");
			String phoneNumber = scanner.next();
			boolean isValidPhone = validations.phoneNumberValidation(phoneNumber);
			while (!isValidPhone) {
				System.err.println("Please enter phone number again(10 digit number)");
				phoneNumber = scanner.next();
				if (validations.phoneNumberValidation(phoneNumber)) {
					break;
				}
			}
			adminBean.setPhoneNumber(phoneNumber);
			System.out.println("Enter Role(Admin)");
			String role = scanner.next();
			boolean isValidRole = validations.roleAdminValidation(role);
			while (!isValidRole) {
				System.err.println("Please enter  valid role again(admin)");
				role = scanner.next();
				if (validations.roleAdminValidation(role)) {
					break;
				}
			}
			adminBean.setRole(role);
			boolean check = services.addAdmin(email, adminBean);
			if (check) {
				System.out.println(adminBean.getRole() + " registered successfully");
			} else {
				System.err.println(adminBean.getRole() + " already exists");
			}
		} catch (Exception e) {
			System.err.println(adminBean.getRole() + " cannot be registered..Please try again!!!");
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
			userBean.setRole(role);
			boolean loginCheck = services.login(userBean);
			if (loginCheck) {
				if (userBean.getRole().equalsIgnoreCase("client")) {
					System.out.println("Welcome Client");
					MainForestry.operations1();
				} else if (userBean.getRole().equalsIgnoreCase("scheduler")) {
					System.out.println("Welcome Scheduler");
					MainForestry.operations2();
				} else {
					System.err.println("Sorry.... " + userBean.getRole() + " is not permitted");
				}
			} else {
				System.err.println("Something went wrong.....Please try again");
			}
		} catch (Exception e) {
			System.err.println("Please.....Try again!!!!!");
		}

	}

	public void signIn() {
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
			adminBean.setEmail(email);
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
			adminBean.setPassword(password);
			boolean loginCheck = services.signIn(adminBean);
			if (loginCheck) {
				System.out.println("Welcome " + adminBean.getName() +" as "+ adminBean.getRole()+"!!!");
				user();

			} else {
				System.err.println("Please register first");
			}
		} catch (Exception e) {
			System.err.println("Try again!!!!!");
		}

	}
	
}
