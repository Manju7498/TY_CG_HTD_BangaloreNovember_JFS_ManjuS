package com.cg.forestrymanagementjpa.controller;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.forestrymanagementjpa.bean.HaulierBean;
import com.cg.forestrymanagementjpa.factory.HaulierFactory;
import com.cg.forestrymanagementjpa.main.MainForestry;
import com.cg.forestrymanagementjpa.service.HaulierService;
import com.cg.forestrymanagementjpa.validations.Validations;

public class HaulierController {
	public void haulier() {
		HaulierService services = HaulierFactory.instanceofHaulierServices();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Validations validations = new Validations();
		while (true) {
			System.out.println("Enter 1 to insert haulier data");
			System.out.println("Enter 2 to delete haulier data");
			System.out.println("Enter 3 to get haulier data");
			System.out.println("Enter 4 to get all haulier data");
			System.out.println("Enter 5 to update haulier data");
			System.out.println("Enter 6  to return to  home");
			HaulierBean haulierBean = new HaulierBean();
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
					System.out.println("Enter Haulier Id");
					String haulierId = scanner.next();
					boolean isValidId = validations.idValidation(haulierId);
					while (!isValidId) {
						System.err.println("Please enter haulier Id again");
						haulierId = scanner.next();
						if (validations.idValidation(haulierId)) {
							break;
						}
					}
					haulierBean.setHaulierId(Integer.parseInt(haulierId));
					System.out.println("Enter haulier name");
					String haulierName = scanner.next();
					boolean isValidName = validations.nameValidation(haulierName);
					while (!isValidName) {
						System.err.println("Please enter haulier name again");
						haulierName = scanner.next();
						if (validations.nameValidation(haulierName)) {
							break;
						}
					}
					haulierBean.setHaulierName(haulierName);
					System.out.println("Enter street address1(includes only _ #)");
					String streetAddress1 = scanner.next();
					boolean isValidAddress1 = validations.addressValidation(streetAddress1);
					while (!isValidAddress1) {
						System.err.println("Please enter address2 again(includes only _ #)");
						streetAddress1 = scanner.next();
						if (validations.addressValidation(streetAddress1)) {
							break;
						}
					}
					haulierBean.setStreetAddress1(streetAddress1);
					System.out.println("Enter street address2(includes only _ #)");
					String streetAddress2 = scanner.next();
					boolean isValidAddress2 = validations.addressValidation(streetAddress2);
					while (!isValidAddress2) {
						System.err.println("Please enter address2 again(includes only _ #)");
						streetAddress2 = scanner.next();
						if (validations.addressValidation(streetAddress2)) {
							break;
						}
					}
					haulierBean.setStreetAddress2(streetAddress2);
					System.out.println("Enter town");
					String town = scanner.next();
					boolean isValidTown = validations.nameValidation(town);
					while (!isValidTown) {
						System.err.println("Please enter town again");
						town = scanner.next();
						if (validations.nameValidation(town)) {
							break;
						}
					}
					haulierBean.setTown(town);
					System.out.println("Enter postal code(Ex:517408)");
					String postcode = scanner.next();
					boolean isValidPin = validations.pincodeValidation(postcode);
					while (!isValidPin) {
						System.err.println("Please enter postcode again(Ex:517408)");
						postcode = scanner.next();
						if (validations.pincodeValidation(postcode)) {
							break;
						}
					}
					haulierBean.setPincode(Integer.parseInt(postcode));
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
					haulierBean.setEmail(email);
					System.out.println("Enter telephone(Ex:9876543210)");
					String phoneNumber = scanner.next();
					boolean isValidPhoneNo = validations.phoneNumberValidation(phoneNumber);
					while (!isValidPhoneNo) {
						System.err.println("Please enter phone number again(Ex:9876543210)");
						phoneNumber = scanner.next();
						if (validations.phoneNumberValidation(phoneNumber)) {
							break;
						}
					}
					haulierBean.setPhoneNumber(Long.parseLong(phoneNumber));
					boolean check = services.insertHaulier(haulierBean);
					if (check) {
						System.out.println("Haulier " + haulierId + " is added successfully");
					} else {
						System.err.println("Haulier " + haulierId + " is repeated");
					}
					break;
				} catch (Exception e) {
					System.out.println("Something went wrong in adding...Please try again");
				}
				break;
			case 2:
				System.out.println("Enter haulier id to delete haulier");
				try {
					int haulierId = scanner.nextInt();
					if (services.deleteHaulier(haulierId)) {
						System.out.println("Haulier " + haulierId + " is deleted");
					} else {
						System.err.println("Haulier " + haulierId + " not found to delete");
					}
				} catch (Exception e) {
					System.err.println("Haulier Id is invalid");
				}
				break;
			case 3:
				System.out.println("Enter id to search haulier");
				try {
					int haulierId = scanner.nextInt();
					if (haulierBean != null) {
						HaulierBean haulierBean1 = services.haulierLogin(haulierId);
						System.out.println("Haulier name : " + haulierBean1.getHaulierName());
						System.out.println("Haulier address1 : " + haulierBean1.getStreetAddress1());
						System.out.println("Haulier address2 : " + haulierBean1.getStreetAddress2());
						System.out.println("Haulier town : " + haulierBean1.getTown());
						System.out.println("Haulier pincode : " + haulierBean1.getPincode());
						System.out.println("Haulier email : " + haulierBean1.getEmail());
						System.out.println("Haulier mobile number : " + haulierBean1.getPhoneNumber());
						System.out.println();
					}
				} catch (Exception e) {
					System.err.println("This Haulier Id is not found");
				}
				break;
			case 4:
				try {
					List<HaulierBean> haulier = services.getAllHauliers();
					if (haulier != null) {
						System.out.println("Haulier Details : ");
						for (HaulierBean haulierBean1 : haulier) {
							System.out.println("Haulier id : " + haulierBean1.getHaulierId());
							System.out.println("Haulier name : " + haulierBean1.getHaulierName());
							System.out.println("Haulier address1 : " + haulierBean1.getStreetAddress1());
							System.out.println("Haulier address2 : " + haulierBean1.getStreetAddress2());
							System.out.println("Haulier town : " + haulierBean1.getTown());
							System.out.println("Haulier pincode : " + haulierBean1.getPincode());
							System.out.println("Haulier email : " + haulierBean1.getEmail());
							System.out.println("Haulier phonenumber : " + haulierBean1.getPhoneNumber());
							System.out.println("*****************************************");
							System.out.println();
						}
					} else {
						System.err.println("No Hauliers found");
					}
				} catch (Exception e) {
					System.err.println("Something Went Wrong");
				}
				break;
			case 5:
				System.out.println("Enter id to modify haulier");
				try {
					int haulierId = scanner.nextInt();
					List<HaulierBean> haulier2 = services.getAllHauliers();
					boolean isupdate = false;
					for (HaulierBean haulierBean1 : haulier2) {
						if (haulierBean1.getHaulierId() == haulierId) {
							isupdate = true;
						}
					}
					if (isupdate) {
						System.out.println("Enter haulier name");
						String newHaulierName = scanner.next();
						boolean isValidNewName = validations.nameValidation(newHaulierName);
						while (!isValidNewName) {
							System.err.println("Please enter haulier name again");
							newHaulierName = scanner.next();
							if (validations.nameValidation(newHaulierName)) {
								break;
							}
						}
						haulierBean.setHaulierName(newHaulierName);
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
						haulierBean.setEmail(newEmail);
						boolean check1 = services.updateHaulier(haulierId, haulierBean);
						if (check1) {
							System.out.println(haulierId + " updated succesfully");
						} else {
							System.err.println(haulierId + " data not present");
						}
					} else {
						System.err.println(haulierId + " is not present");
					}
				} catch (Exception e) {
					System.err.println("No Hauliers present to update");
				}
				break;
			case 6:
				MainForestry.home();
				break;
			default:
				break;
			}
		}
	}
}
