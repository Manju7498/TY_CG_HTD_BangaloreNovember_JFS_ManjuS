package com.cg.forestrymanagementjdbc.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.forestrymanagementjdbc.bean.ContractBean;
import com.cg.forestrymanagementjdbc.factory.ContractFactory;
import com.cg.forestrymanagementjdbc.main.MainForestry;
import com.cg.forestrymanagementjdbc.service.ContractService;
import com.cg.forestrymanagementjdbc.validations.Validations;

public class ContractController {
	public void contract() {
		ContractService services = ContractFactory.instanceofContractServices();
		ContractBean bean = new ContractBean();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Validations validations = new Validations();
		while (true) {
			System.out.println("Enter 1 to insert contract data");
			System.out.println("Enter 2 to delete contract data");
			System.out.println("Enter 3 to get contract data");
			System.out.println("Enter 4 to get all contract details");
			System.out.println("Enter 5 to update contract data");
			System.out.println("Enter 6 to return to home");
			String choice = scanner.next();
			Pattern pattern = Pattern.compile("^[1-6]{1}$");
			ContractBean contractBean = new ContractBean();
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
					System.out.println("Enter contractNo");
					String contractNo = scanner.next();
					boolean isValidNo = validations.idValidation(contractNo);
					while (!isValidNo) {
						System.err.println("Please enter contract No again");
						contractNo = scanner.next();
						if (validations.idValidation(contractNo)) {
							break;
						}
					}
					contractBean.setContractNo(Integer.parseInt(contractNo));
					System.out.println("Enter customerId");
					String customerId = scanner.next();
					boolean isValidId = validations.idValidation(customerId);
					while (!isValidId) {
						System.err.println("Please enter customer Id again");
						customerId = scanner.next();
						if (validations.idValidation(customerId)) {
							break;
						}
					}
					contractBean.setCustomerId(Integer.parseInt(customerId));
					System.out.println("Enter productId");
					String productId = scanner.next();
					boolean isValidProductId = validations.idValidation(productId);
					while (!isValidProductId) {
						System.err.println("Please enter product Id again");
						productId = scanner.next();
						if (validations.idValidation(productId)) {
							break;
						}
					}
					contractBean.setProductId(Integer.parseInt(productId));
					System.out.println("Enter haulierId");
					String haulierId = scanner.next();
					boolean isValidHaulierId = validations.idValidation(haulierId);
					while (!isValidHaulierId) {
						System.err.println("Please enter haulier Id again");
						haulierId = scanner.next();
						if (validations.idValidation(haulierId)) {
							break;
						}
					}
					contractBean.setHaulierId(Integer.parseInt(haulierId));
					System.out.println("enter delivery date(yyyy-mm-dd)");
					String deliveryDate = scanner.next();
					boolean isValidDate = validations.dateValidation(deliveryDate);
					while (!isValidDate) {
						System.err.println("Please enter delivery date again(yyyy-mm-dd)");
						deliveryDate = scanner.next();
						if (validations.dateValidation(deliveryDate)) {
							break;
						}
					}
					contractBean.setDeliveryDate(deliveryDate);
					System.out.println("Your Delivery Day");
					String deliveryDate1 = contractBean.getDeliveryDate();
					SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
					Date dt1 = format1.parse(deliveryDate1);
					DateFormat format2 = new SimpleDateFormat("EEEE");
					String deliveryDay = format2.format(dt1);
					System.out.println(deliveryDay);
					contractBean.setDeliveryDay(deliveryDay);
					System.out.println("Enter quantity");
					String quantity = scanner.next();
					boolean isValidQuantity = validations.idValidation(quantity);
					while (!isValidQuantity) {
						System.err.println("Please enter quantity again");
						quantity = scanner.next();
						if (validations.idValidation(contractNo)) {
							break;
						}
					}
					contractBean.setQuantity(Integer.parseInt(quantity));
					boolean check = services.addContract(contractBean);
					if (check) {
						System.out.println("Contract added successfuly");
					} else {
						System.err.println("ContractNo is repeated");
					}
				} catch (Exception e) {
					System.err.println("ContractNo is repeated");
				}
				break;
			case 2:
				System.out.println("Enter contractno to delete contract");
				try {
					String contractNo2 = scanner.next();
					if (services.deleteContract(Integer.parseInt(contractNo2))) {
						System.out.println("Contract deleted");
					} else {
						System.err.println("Contract not found to delete");
					}
				} catch (Exception e) {
					System.err.println("ContractNo is invalid");
				}
				break;
			case 3:
				System.out.println("Enter contractNo to search contract");
				try {
					int contractNo1 = scanner.nextInt();
					if (contractBean != null) {
						ContractBean contractBean1 = services.getContract(contractNo1);
						System.out.println("Customer Id : " + contractBean1.getCustomerId());
						System.out.println("Product id : " + contractBean1.getProductId());
						System.out.println("Haulier Id : " + contractBean1.getHaulierId());
						System.out.println("Delivery date : " + contractBean1.getDeliveryDate());
						System.out.println("Delivery day : " + contractBean1.getDeliveryDay());
						System.out.println("Quantity : " + contractBean1.getQuantity());
						System.out.println();
					}
				} catch (Exception e) {
					System.err.println("ContractNo is  not found");
				}
				break;
			case 4:
				try {
					List<ContractBean> contract1 = services.getAllContracts();
					if (contract1 != null) {
						System.out.println("Contract Details : ");
						for (ContractBean contractBean2 : contract1) {
							System.out.println("Contract No : " + contractBean2.getContractNo());
							System.out.println("Customer Id : " + contractBean2.getCustomerId());
							System.out.println("Product Id : " + contractBean2.getProductId());
							System.out.println("Haulier Id : " + contractBean2.getHaulierId());
							System.out.println("Delivery Date : " + contractBean2.getDeliveryDate());
							System.out.println("Delivary day : " + contractBean2.getDeliveryDay());
							System.out.println("Quantity : " + contractBean2.getQuantity());
							System.out.println("***********************************************");
							System.out.println();
						}
					} else {
						System.err.println("No contracts Found");
					}
				} catch (Exception e) {
					System.err.println("No Contracts found in list");
				}
				break;
			case 5:
				System.out.println("Enter Id to modify contract data ");
				try {
					bean = new ContractBean();
					int contractNo = scanner.nextInt();
					List<ContractBean> contract2 = services.getAllContracts();
					boolean isUpdate = false;
					for (ContractBean contractBean2 : contract2) {
						if (contractBean2.getContractNo() == contractNo) {
							isUpdate = true;
						}
					}
					if (isUpdate) {
						System.out.println("Enter customer Id");
						String newCustomerId = scanner.next();
						boolean isValidNewName = validations.idValidation(newCustomerId);
						while (!isValidNewName) {
							System.err.println("Please enter Id again");
							newCustomerId = scanner.next();
							if (validations.idValidation(newCustomerId)) {
								break;
							}
						}
						bean.setCustomerId(Integer.parseInt(newCustomerId));
						System.out.println("Enter product Id");
						String newProductId = scanner.next();
						boolean isValidNew = validations.idValidation(newProductId);
						while (!isValidNew) {
							System.err.println("Please enter Id again");
							newProductId = scanner.next();
							if (validations.idValidation(newProductId)) {
								break;
							}
						}
						bean.setProductId(Integer.parseInt(newProductId));
						boolean check1 = services.updateContract(contractNo, bean);
						if (check1) {
							System.out.println("contract data updated succesfully");
						} else {
							System.err.println("contract not found to update");
						}
					} else {
						System.err.println("Contract Id not found");
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
