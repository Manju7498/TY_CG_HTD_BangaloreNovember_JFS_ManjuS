package com.cg.forestrymanagementjdbc.controller;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.forestrymanagementjdbc.bean.HaulierBean;
import com.cg.forestrymanagementjdbc.factory.HaulierFactory;
import com.cg.forestrymanagementjdbc.main.MainForestry;
import com.cg.forestrymanagementjdbc.service.HaulierService;
import com.cg.forestrymanagementjdbc.validations.Validations;

public class HaulierController {
	public void haulier() {
		HaulierService services = HaulierFactory.instanceofHaulierServices();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		HaulierBean bean = new HaulierBean();
		Validations validations = new Validations();
		while (true) {
			System.out.println("Enter 1 to insert haulier data");
			System.out.println("Enter 2 to delete haulier data");
			System.out.println("Enter 3 to get haulier data");
			System.out.println("Enter 4 to get all haulier data");
			System.out.println("Enter 5 to update haulier  data");
			System.out.println("Enter 6 to return to  home");
			String choice = scanner.next();
			Pattern pattern = Pattern.compile("^[1-6]{1}$");
			HaulierBean haulierBean = new HaulierBean();
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
					System.out.println("Enter haulier Id");
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
						System.err.println("Please enter name again");
						haulierName = scanner.next();
						if (validations.nameValidation(haulierName)) {
							break;
						}
					}
					haulierBean.setHaulierName(haulierName);
					System.out.println("Enter street address1");
					String streetAddress1 = scanner.next();
					boolean isValidAddress1 = validations.addressValidation(streetAddress1);
					while (!isValidAddress1) {
						System.err.println("Please enter address1 again");
						streetAddress1 = scanner.next();
						if (validations.addressValidation(streetAddress1)) {
							break;
						}
					}
					haulierBean.setStreetAddress1(streetAddress1);
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
					haulierBean.setStreetAddress2(streetAddress2);
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
					haulierBean.setTown(town);
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
					haulierBean.setPostcode(Integer.parseInt(postcode));
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
					haulierBean.setEmail(email);
					System.out.println("Enter telephone");
					String phoneNumber = scanner.next();
					boolean isValidPhoneNo = validations.phoneNumberValidation(phoneNumber);
					while (!isValidPhoneNo) {
						System.err.println("Please enter phone number again");
						phoneNumber = scanner.next();
						if (validations.phoneNumberValidation(phoneNumber)) {
							break;
						}
					}
					haulierBean.setPhonenumber(Long.parseLong(phoneNumber));
					boolean check = services.insertHaulier(haulierBean);
					if (check) {
						System.out.println("haulier added");
					} else {
						System.err.println("Haulier Id is repeated");
					}
				} catch (Exception e) {
					System.err.println("Haulier cannot be added");
				}
				break;
			case 2:
				System.out.println("Enter Id to delete haulier");
				try {
					int choicetodelete = scanner.nextInt();
					if (services.deleteHaulier(choicetodelete)) {
						System.out.println("Haulier " + haulierBean.getHaulierId() + "  deleted");
					} else {
						System.err.println("Haulier Id not found to delete");
					}
				} catch (Exception e) {
					System.err.println("Haulier id is invalid");
				}
				break;
			case 3:
				try {
					System.out.println("Enter Id to search haulier");
					int haulierId = scanner.nextInt();
					if (bean != null) {
						HaulierBean haulierBean1 = services.haulierLogin(haulierId);
						System.out.println("Haulier name : " + haulierBean1.getHaulierName());
						System.out.println("Haulier address1 : " + haulierBean1.getStreetAddress1());
						System.out.println("Haulier address2 : " + haulierBean1.getStreetAddress2());
						System.out.println("Haulier town : " + haulierBean1.getTown());
						System.out.println("Haulier pincode : " + haulierBean1.getPostcode());
						System.out.println("Haulier email : " + haulierBean1.getEmail());
						System.out.println("Haulier mobile number : " + haulierBean1.getPhonenumber());
						System.out.println();
					}
				} catch (Exception e) {
					System.err.println("Haulier " + haulierBean.getHaulierId() + " is  not found");
				}
				break;
			case 4:
				try {
					List<HaulierBean> haulier = services.getAllHauliers();
					System.out.println("Haulier Details : ");
					if (haulier != null) {
						for (HaulierBean haulierBean2 : haulier) {
							System.out.println("Haulier id : " + haulierBean2.getHaulierId());
							System.out.println("Haulier name : " + haulierBean2.getHaulierName());
							System.out.println("Haulier address1 : " + haulierBean2.getStreetAddress1());
							System.out.println("Haulier address2 : " + haulierBean2.getStreetAddress2());
							System.out.println("Haulier town : " + haulierBean2.getTown());
							System.out.println("Haulier pincode : " + haulierBean2.getPostcode());
							System.out.println("Haulier email : " + haulierBean2.getEmail());
							System.out.println("Haulier mobile number : " + haulierBean2.getPhonenumber());
							System.out.println();
						}
					}else {
						System.err.println("No hauliers found");
					}
				} catch (Exception e) {
					System.err.println("No hauliers found");
				}
				break;
			case 5:
				System.out.println("Enter Id to modify haulier data ");
				try {
					bean = new HaulierBean();
					int haulierId1 = scanner.nextInt();
					List<HaulierBean> haulier2 = services.getAllHauliers();
					boolean isUpdate = false;
					for (HaulierBean haulierBean2 : haulier2) {
						if (haulierBean2.getHaulierId() == haulierId1) {
							isUpdate = true;
						}
					}
					if (isUpdate) {
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
						bean.setHaulierName(newHaulierName);
						System.out.println("Enter haulier email");
						String newHaulierEmail = scanner.next();
						boolean isValidNewEmail = validations.emailValidation(newHaulierEmail);
						while (!isValidNewEmail) {
							System.err.println("Please enter haulier email again");
							newHaulierEmail = scanner.next();
							if (validations.emailValidation(newHaulierEmail)) {
								break;
							}
						}
						bean.setEmail(newHaulierEmail);
						boolean check1 = services.updateHaulier(haulierId1, bean);
						if (check1) {
							System.out.println("haulier " + haulierBean.getHaulierId() + " updated succesfully");
						} else {
							System.err.println("haulier not found to update");
						}
					} else {
						System.err.println("Haulier "+haulierBean.getHaulierId()+"  not found");
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
