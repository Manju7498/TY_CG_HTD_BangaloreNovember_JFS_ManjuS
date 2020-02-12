package com.cg.forestrymanagementcollections.controller;

import java.util.HashMap;
import java.util.Scanner;

import com.cg.forestrymanagementcollections.bean.CustomerBean;
import com.cg.forestrymanagementcollections.factory.CustomerFactory;
import com.cg.forestrymanagementcollections.main.MainForestry;
import com.cg.forestrymanagementcollections.service.CustomerService;
import com.cg.forestrymanagementcollections.validations.Validations;

import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomerController {
	public void customer() {
		CustomerService services = CustomerFactory.instanceofCustomerServices();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Validations validations = new Validations();
		while (true) {
			System.out.println("Enter 1 to insert customer data");
			System.out.println("Enter 2 to delete customer data");
			System.out.println("Enter 3 to get customer data");
			System.out.println("Enter 4 to get all customer data");
			System.out.println("Enter 5 to update customer data");
			System.out.println("Enter 6  to return to  home");
			CustomerBean customerBean = new CustomerBean();
			String choice = scanner.next();
			Pattern pattern = Pattern.compile("^[1-6]{1}$");
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
				try {
					System.out.println("Enter Customer Id");
					String customerId = scanner.next();
					boolean isValidId = validations.idValidation(customerId);
					while (!isValidId) {
						System.err.println("Please enter valid customer Id again");
						customerId = scanner.next();
						if (validations.idValidation(customerId)) {
							break;
						}
					}
					customerBean.setCustomerId(Integer.parseInt(customerId));
					System.out.println("Enter customer name");
					String customerName = scanner.next();
					boolean isValidName = validations.nameValidation(customerName);
					while (!isValidName) {
						System.err.println("Please enter customer name again");
						customerName = scanner.next();
						if (validations.nameValidation(customerName)) {
							break;
						}
					}
					customerBean.setCustomerName(customerName);
					System.out.println("Enter street address1(includes only _ #)");
					String streetAddress1 = scanner.next();
					boolean isValidAddress1 = validations.addressValidation(streetAddress1);
					while (!isValidAddress1) {
						System.err.println("Please enter address1 again(includes only _ #)");
						streetAddress1 = scanner.next();
						if (validations.addressValidation(streetAddress1)) {
							break;
						}
					}
					customerBean.setStreetAddress1(streetAddress1);
					System.out.println("Enter street address2(includes only _ #)");
					String streetAddress2 = scanner.next();
					boolean isValidAddress2 = validations.addressValidation(streetAddress2);
					while (!isValidAddress2) {
						System.err.println("Please enter address2 again(includes only _ #)");
						streetAddress1 = scanner.next();
						if (validations.addressValidation(streetAddress1)) {
							break;
						}
					}
					customerBean.setStreetAddress2(streetAddress2);
					System.out.println("Enter town");
					String town = scanner.next();
					boolean isValidTown = validations.townValidation(town);
					while (!isValidTown) {
						System.err.println("Please enter town again");
						town = scanner.next();
						if (validations.townValidation(town)) {
							break;
						}
					}
					customerBean.setTown(town);
					System.out.println("Enter postal code(Ex:517408)");
					String postcode = scanner.next();
					boolean isValidPin = validations.pincodeValidation(postcode);
					while (!isValidPin) {
						System.err.println("Please enter  valid postcode again(Ex:517408)");
						postcode = scanner.next();
						if (validations.pincodeValidation(postcode)) {
							break;
						}
					}
					customerBean.setPincode(Integer.parseInt(postcode));
					System.out.println("Enter email(ex:john@gmail.com)");
					String email = scanner.next();
					boolean isValidEmail = validations.emailValidation(email);
					while (!isValidEmail) {
						System.err.println("Please enter email again(ex:john@gmail.com)");
						email = scanner.next();
						if (validations.emailValidation(email)) {
							break;
						}
					}
					customerBean.setEmail(email);
					System.out.println("Enter telephone(Ex:9876543210)");
					String phoneNumber = scanner.next();
					boolean isValidPhoneNo = validations.phoneNumberValidation(phoneNumber);
					while (!isValidPhoneNo) {
						System.out.println("Please enter valid phone number again(Ex:9876543210)");
						phoneNumber = scanner.next();
						if (validations.phoneNumberValidation(phoneNumber)) {
							break;
						}
					}
					customerBean.setCustomerPhoneNumber(Long.parseLong(phoneNumber));
					boolean check = services.addCustomer(Integer.parseInt(customerId), customerBean);
					if (check) {
						System.out.println("Customer " + customerId + " added successfuly");
					} else {
						System.err.println("Customer " + customerId + " is repeated");
					}
				} catch (Exception e) {
					System.err.println("Something went wrong in adding...Please try again");
				}
				break;
			case 2:
				System.out.println("Enter Customer Id to delete customer");
				try {
					int customerId = scanner.nextInt();
					if (services.deleteCustomer(customerId)) {
						System.out.println("Customer " + customerId + " is  deleted");
					} else {
						System.err.println("Customer " + customerId + " not found to delete");
					}
				} catch (Exception e) {
					System.err.println("CustomerId is invalid");
				}
				break;
			case 3:
				System.out.println("Enter Id to search customer");
				try {
					int customerId = scanner.nextInt();
					if (customerBean != null) {
						CustomerBean customerBean1 = services.getCustomer(customerId);
						System.out.println("Customer name : " + customerBean1.getCustomerName());
						System.out.println("Customer address1 : " + customerBean1.getStreetAddress1());
						System.out.println("Customer address2 : " + customerBean1.getStreetAddress2());
						System.out.println("Customer town : " + customerBean1.getTown());
						System.out.println("Customer pincode : " + customerBean1.getPincode());
						System.out.println("Customer email : " + customerBean1.getEmail());
						System.out.println("Customer mobile number : " + customerBean1.getCustomerPhoneNumber());
						System.out.println();
					}
				} catch (Exception e) {
					System.err.println("Such customer is not present");
				}
				break;
			case 4:
				try {
					HashMap<Integer, CustomerBean> customer = services.getAllCustomers();
					if (customer != null) {
						System.out.println("Customers Details : ");
						for (Entry<Integer, CustomerBean> customerbean : customer.entrySet()) {
							System.out.println("Customer Id : " + customerbean.getKey());
							System.out.println("Customer name : " + customerbean.getValue().getCustomerName());
							System.out.println("Customer address1 : " + customerbean.getValue().getStreetAddress1());
							System.out.println("Customer address2 : " + customerbean.getValue().getStreetAddress2());
							System.out.println("Customer town : " + customerbean.getValue().getTown());
							System.out.println("Customer pincode : " + customerbean.getValue().getPincode());
							System.out.println("Customer email : " + customerbean.getValue().getEmail());
							System.out.println(
									"Customer phonenumber : " + customerbean.getValue().getCustomerPhoneNumber());
							System.out.println("*****************************************");
						}
					} else {
						System.err.println("No Customers found");
					}
				} catch (Exception e) {
					System.err.println("Something Went Wrong");
				}
				break;
			case 5:
				System.out.println("Enter Id to modify customer");
				try {
					int customerId1 = scanner.nextInt();
					HashMap<Integer, CustomerBean> customer2 = services.getAllCustomers();
					boolean isUpdate = false;
					for (Entry<Integer, CustomerBean> customer : customer2.entrySet()) {
						if (customer.getKey() == customerId1) {
							isUpdate = true;
						}
					}
					if (isUpdate) {
						System.out.println("Enter customer name");
						String newCustomerName = scanner.next();
						boolean isValidNewName = validations.nameValidation(newCustomerName);
						while (!isValidNewName) {
							System.err.println("Please enter name again");
							newCustomerName = scanner.next();
							if (validations.nameValidation(newCustomerName)) {
								break;
							}
						}
						customerBean.setCustomerName(newCustomerName);
						System.out.println("Enter customer street address1(includes only _ #)");
						String newStreetAddress1 = scanner.next();
						boolean isValidNewAddress1 = validations.addressValidation(newStreetAddress1);
						while (!isValidNewAddress1) {
							System.err.println("Please enter address1 again(includes only _ #)");
							newStreetAddress1 = scanner.next();
							if (validations.addressValidation(newStreetAddress1)) {
								break;
							}
						}
						customerBean.setStreetAddress1(newStreetAddress1);
						System.out.println("enter street address2(includes only _ #)");
						String newStreetAddress2 = scanner.next();
						boolean isValidNewAddress2 = validations.addressValidation(newStreetAddress1);
						while (!isValidNewAddress2) {
							System.err.println("Please enter address2 again(includes only _ #)");
							newStreetAddress1 = scanner.next();
							if (validations.addressValidation(newStreetAddress2)) {
								break;
							}
						}
						customerBean.setStreetAddress2(newStreetAddress2);
						System.out.println("enter town");
						String newTown = scanner.next();
						boolean isValidNewTown = validations.townValidation(newTown);
						while (!isValidNewTown) {
							System.err.println("Please enter town again");
							newTown = scanner.next();
							if (validations.townValidation(newTown)) {
								break;
							}
						}
						customerBean.setTown(newTown);
						System.out.println("enter pincode(Ex:517408)");
						String newPostcode = scanner.next();
						boolean isValidNewPin = validations.pincodeValidation(newPostcode);
						while (!isValidNewPin) {
							System.err.println("Please enter postcode again(Ex:517408)");
							newPostcode = scanner.next();
							if (validations.pincodeValidation(newPostcode)) {
								break;
							}
						}
						customerBean.setPincode(Integer.parseInt(newPostcode));
						System.out.println("enter email(Ex:john@gmail.com)");
						String newEmail = scanner.next();
						boolean isValidNewEmail = validations.emailValidation(newEmail);
						while (!isValidNewEmail) {
							System.err.println("Please enter email again(Ex:john@gmail.com)");
							newEmail = scanner.next();
							if (validations.emailValidation(newEmail)) {
								break;
							}
						}
						customerBean.setEmail(newEmail);
						System.out.println("enter phone number(Ex:9876543210)");
						String newPhoneNumber = scanner.next();
						boolean isValidNewPhoneNo = validations.phoneNumberValidation(newPhoneNumber);
						while (!isValidNewPhoneNo) {
							System.err.println("Please enter phone number again(Ex:9876543210)");
							newPhoneNumber = scanner.next();
							if (validations.phoneNumberValidation(newPhoneNumber)) {
								break;
							}
						}
						customerBean.setCustomerPhoneNumber(Long.parseLong(newPhoneNumber));
						boolean check1 = services.updateCustomer(customerId1, customerBean);
						if (check1) {
							System.out.println(customerId1 + " updated succesfully");
						} else {
							System.err.println(customerId1 + " data not present");
						}
					} else {
						System.err.println(customerId1 + " is not present");
					}
				} catch (Exception e) {
					System.err.println("No Customers present to update");
				}
				break;
			case 6:
				MainForestry.operations1();
				break;
			default:
				break;
			}
		}
	}
}
