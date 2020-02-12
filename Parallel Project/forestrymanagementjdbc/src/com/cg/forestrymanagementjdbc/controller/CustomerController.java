package com.cg.forestrymanagementjdbc.controller;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.forestrymanagementjdbc.bean.CustomerBean;
import com.cg.forestrymanagementjdbc.factory.CustomerFactory;
import com.cg.forestrymanagementjdbc.main.MainForestry;
import com.cg.forestrymanagementjdbc.service.CustomerService;
import com.cg.forestrymanagementjdbc.validations.Validations;

public class CustomerController {
	public void customer() {
		CustomerService services = CustomerFactory.instanceofCustomerServices();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		CustomerBean bean = new CustomerBean();
		Validations validations = new Validations();
		while (true) {
			System.out.println("Enter 1 to insert customer data");
			System.out.println("Enter 2 to delete customer data");
			System.out.println("Enter 3 to get customer data");
			System.out.println("Enter 4 to get all customer data");
			System.out.println("Enter 5 to update customer  data");
			System.out.println("Enter 6 to return to  home");
			String choice = scanner.next();
			Pattern pattern = Pattern.compile("^[1-8]{1}$");
			CustomerBean customerBean = new CustomerBean();
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
					System.out.println("Enter customer Id");
					String customerId = scanner.next();
					boolean isValidId = validations.idValidation(customerId);
					while (!isValidId) {
						System.err.println("Please enter customer Id again");
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
						System.err.println("Please enter name again");
						customerName = scanner.next();
						if (validations.nameValidation(customerName)) {
							break;
						}
					}
					customerBean.setCustomerName(customerName);
					System.out.println("Enter street address1");
					String streetAddress1 = scanner.next();
					boolean isValidAddress1 = validations.addressValidation(streetAddress1);
					while (!isValidAddress1) {
						System.out.println("Please enter address1 again");
						streetAddress1 = scanner.next();
						if (validations.addressValidation(streetAddress1)) {
							break;
						}
					}
					customerBean.setStreetAddress1(streetAddress1);
					System.out.println("Enter street address2");
					String streetAddress2 = scanner.next();
					boolean isValidAddress2 = validations.addressValidation(streetAddress2);
					while (!isValidAddress2) {
						System.err.println("Please enter address2 again");
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
					System.out.println("Enter postal code");
					String postcode = scanner.next();
					boolean isValidPin = validations.pincodeValidation(postcode);
					while (!isValidPin) {
						System.err.println("Please enter postcode again");
						postcode = scanner.next();
						if (validations.pincodeValidation(postcode)) {
							break;
						}
					}
					customerBean.setPincode(Integer.parseInt(postcode));
					System.out.println("Enter email");
					String email = scanner.next();
					boolean isValidEmail = validations.emailValidation(email);
					while (!isValidEmail) {
						System.err.println("Please enter email again");
						email = scanner.next();
						if (validations.emailValidation(email)) {
							break;
						}
					}
					customerBean.setEmail(email);
					System.out.println("Enter telephone number");
					String phoneNumber = scanner.next();
					boolean isValidPhoneNo = validations.phoneNumberValidation(phoneNumber);
					while (!isValidPhoneNo) {
						System.err.println("Please enter phone number again");
						phoneNumber = scanner.next();
						if (validations.phoneNumberValidation(phoneNumber)) {
							break;
						}
					}
					customerBean.setCustomerPhoneNumber(Long.parseLong(phoneNumber));
					boolean check = services.insertCustomer(customerBean);
					if (check) {
						System.out.println("Customer added");
					} else {
						System.err.println("Customer Id is repeated");
					}
				} catch (Exception e) {
					System.err.println("Something went wrong ...try again");
				}
				break;
			case 2:
				System.out.println("Enter Id to delete customer");
				try {
					int choicetodelete = scanner.nextInt();
					if (services.deleteCustomer(choicetodelete)) {
						System.out.println("Customer deleted");
					} else {
						System.err.println("Customer not found to delete");
					}
				} catch (Exception e) {
					System.err.println("CustomerId is invalid");
				}
				break;
			case 3:
				System.out.println("Enter Id to search customer");
				try {
					int customerId = scanner.nextInt();
					if (bean != null) {
						CustomerBean customerBean1 = services.customerLogin(customerId);
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
					System.err.println(" No such sCustomerId  is  not found");
				}
				break;
			case 4:
				try {
					List<CustomerBean> customer = services.getAllCustomers();
					if (customer != null) {
						System.out.println("Customers Details : ");
						for (CustomerBean customerBean2 : customer) {
							System.out.println("Customer Id : " + customerBean2.getCustomerId());
							System.out.println("Customer name : " + customerBean2.getCustomerName());
							System.out.println("Customer address1 : " + customerBean2.getStreetAddress1());
							System.out.println("Customer address2 : " + customerBean2.getStreetAddress2());
							System.out.println("Customer town : " + customerBean2.getTown());
							System.out.println("Customer pincode : " + customerBean2.getPincode());
							System.out.println("Customer email : " + customerBean2.getEmail());
							System.out.println("Customer phonenumber : " + customerBean2.getCustomerPhoneNumber());
							System.out.println("*****************************************");
							System.out.println();
						}
					}else {
						System.err.println("No customers found");
					}
				} catch (Exception e) {
					System.err.println("No Customers found");
				}
				break;
			case 5:
				System.out.println("Enter Id to modify customer name ");
				try {
					bean = new CustomerBean();
					int customerId1 = scanner.nextInt();
					List<CustomerBean> customer2 = services.getAllCustomers();
					boolean isUpdate = false;
					for (CustomerBean customerBean2 : customer2) {
						if (customerBean2.getCustomerId() == customerId1) {
							isUpdate = true;
						}
					}
					if(isUpdate) {
					System.out.println("Enter customer name");
					String newCustomerName = scanner.next();
					boolean isValidNewName = validations.nameValidation(newCustomerName);
					while (!isValidNewName) {
						System.err.println("Please enter customer name again");
						newCustomerName = scanner.next();
						if (validations.nameValidation(newCustomerName)) {
							break;
						}
					}
					bean.setCustomerName(newCustomerName);
					System.out.println("Enter customer email");
					String newCustomerEmail = scanner.next();
					boolean isValidNewEmail = validations.emailValidation(newCustomerEmail);
					while (!isValidNewEmail) {
						System.err.println("Please enter customer email again");
						newCustomerEmail = scanner.next();
						if (validations.emailValidation(newCustomerEmail)) {
							break;
						}
					}
					bean.setEmail(newCustomerEmail);
					boolean check1 = services.updateCustomer(customerId1, bean);
					if (check1) {
						System.out.println("Customer data updated succesfully");
					} else {
						System.err.println("Customer not found to update");
					}
					}else {
						System.err.println("Customer Id not found");
					}
				} catch (Exception e) {
					System.err.println("Id not found");
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
