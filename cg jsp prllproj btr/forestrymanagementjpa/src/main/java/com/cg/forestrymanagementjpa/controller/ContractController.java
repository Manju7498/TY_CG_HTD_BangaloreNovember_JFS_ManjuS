package com.cg.forestrymanagementjpa.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.forestrymanagementjpa.bean.ContractBean;
import com.cg.forestrymanagementjpa.bean.CustomerBean;
import com.cg.forestrymanagementjpa.bean.HaulierBean;
import com.cg.forestrymanagementjpa.bean.ProductBean;
import com.cg.forestrymanagementjpa.factory.ContractFactory;
import com.cg.forestrymanagementjpa.factory.CustomerFactory;
import com.cg.forestrymanagementjpa.factory.HaulierFactory;
import com.cg.forestrymanagementjpa.factory.ProductFactory;
import com.cg.forestrymanagementjpa.main.MainForestry;
import com.cg.forestrymanagementjpa.service.ContractService;
import com.cg.forestrymanagementjpa.service.CustomerService;
import com.cg.forestrymanagementjpa.service.HaulierService;
import com.cg.forestrymanagementjpa.service.ProductService;
import com.cg.forestrymanagementjpa.validations.Validations;

public class ContractController {
	public void contractor() {
		ContractService services = ContractFactory.instanceofContractServices();
		CustomerService customerService= CustomerFactory.instanceofCustomerServices();
		ProductService productService=ProductFactory.instanceofProductServices();
		HaulierService haulierService=HaulierFactory.instanceofHaulierServices();
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
			ContractBean contract = new ContractBean();
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
					System.out.println("Enter Contract No");
					String contractNo = scanner.next();
					boolean isValidNo = validations.idValidation(contractNo);
					while (!isValidNo) {
						System.err.println("Please enter contract no again");
						contractNo = scanner.next();
						if (validations.idValidation(contractNo)) {
							break;
						}
					}
					contract.setContractNo(Integer.parseInt(contractNo));
					System.out.println("Enter Customer Id");
					String customerId = scanner.next();
					boolean isValidId = validations.idValidation(customerId);
					while(!isValidId) {
						System.err.println("Please enter customer Id again");
						customerId = scanner.next();
						if (validations.idValidation(customerId)) {
							break;
						}
					}
					CustomerBean customer=customerService.customerLogin(Integer.parseInt(customerId));
					while (customer==null) {
						System.err.println("Please enter valid customer Id again");
						customerId = scanner.next();
						while(isValidId != validations.idValidation(customerId) ) {
							System.err.println("Please enter customer Id again");
							customerId = scanner.next();
							if (validations.idValidation(customerId)) {
								break;
							}
						}
						if (customerService.customerLogin(Integer.parseInt(customerId))!=null) 
							break;
					}
					contract.setCustomerId(Integer.parseInt(customerId));
					// product
					System.out.println("Enter product Id");
					String productId = scanner.next();
					boolean isValidProductId = validations.idValidation(productId);
					while(!isValidProductId) {
						System.err.println("Please enter product Id again");
						productId = scanner.next();
						if (validations.idValidation(productId)) {
							break;
						}
					}
					ProductBean productBean=productService.productLogin(Integer.parseInt(productId));
					while (productBean==null) {
						System.err.println("Please enter valid product Id again");
						productId = scanner.next();
						while(isValidProductId!= validations.idValidation(productId)) {
							System.err.println("Please enter product Id again");
							productId = scanner.next();
							if (validations.idValidation(productId)) {
								break;
							}
						}
						if (productService.productLogin(Integer.parseInt(productId))!=null) 
							break;
					}
					contract.setProductId(Integer.parseInt(productId));
					// haulier
					System.out.println("Enter haulier Id");
					String haulierId = scanner.next();
					boolean isValidHaulierId = validations.idValidation(haulierId);
					while(!isValidHaulierId) {
						System.err.println("Please enter haulier Id again");
						haulierId = scanner.next();
						if (validations.idValidation(haulierId)) {
							break;
						}
					}
					HaulierBean haulierBean=haulierService.haulierLogin(Integer.parseInt(haulierId));
					while (haulierBean==null) {
						System.err.println("Please enter valid haulier Id again");
						haulierId = scanner.next();
						while(isValidHaulierId!= validations.idValidation(haulierId)) {
							System.err.println("Please enter haulier Id again");
							haulierId = scanner.next();
							if (validations.idValidation(haulierId)) {
								break;
							}
						}
						if (haulierService.haulierLogin(Integer.parseInt(haulierId))!=null) 
							break;
					}
					contract.setHaulierId(Integer.parseInt(haulierId));
					// delivery date
					System.out.println("enter Delivery Date(yyyy-mm-dd)");
					String deliveryDate = scanner.next();
					boolean isValidDate = validations.dateValidation(deliveryDate);
					while (!isValidDate) {
						System.err.println("Please enter valid future delivery date again(yyyy-mm-dd)");
						deliveryDate = scanner.next();
						if (validations.dateValidation(deliveryDate)) {
							break;
						}
					}
					contract.setDeliveryDate(deliveryDate);
					// delivery day
					System.out.println("Your Delivery Day");
					String deliveryDate1 = contract.getDeliveryDate();
					SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
					Date dt1 = format1.parse(deliveryDate1);
					DateFormat format2 = new SimpleDateFormat("EEEE");
					String deliveryDay = format2.format(dt1);
					System.out.println(deliveryDay);
					contract.setDeliveryDay(deliveryDay);
					// quantity
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
					contract.setQuantity(Integer.parseInt(quantity));
					boolean check = services.insertContract(contract);
					if (check) {
						System.out.println("Contract " + contractNo + " added successfuly");
					} else {
						System.err.println("Contract " + contractNo + " is repeated");
					}			
					} catch (Exception e) {
						e.printStackTrace();
					System.err.println("Something went wrong in adding...Please try again");
				}
				break;
			case 2:
				System.out.println("Enter contractno to delete contract");
				try {
					String contractNo2 = scanner.next();
					if (services.deleteContract(Integer.parseInt(contractNo2))) {
						System.out.println("Contract " + contractNo2 + " is  deleted");
					} else {
						System.err.println("Contract " + contractNo2 + " not found to delete");
					}
				} catch (Exception e) {
					System.err.println("Contract No is invalid");
				}
				break;
			case 3:
				System.out.println("Enter contractNo to search contract");
				try {
					int contractNo1 = scanner.nextInt();
					if (contract != null) {
						ContractBean contractBean1 = services.contractLogin(contractNo1);
						System.out.println("Customer Id : " + contractBean1.getCustomerId());
						System.out.println("Product id : " + contractBean1.getProductId());
						System.out.println("Haulier Id : " + contractBean1.getHaulierId());
						System.out.println("Delivery date : " + contractBean1.getDeliveryDate());
						System.out.println("Delivery day : " + contractBean1.getDeliveryDay());
						System.out.println("Quantity : " + contractBean1.getQuantity());
						System.out.println();
					}
				} catch (Exception e) {
					System.err.println("Such Contract is not present");
				}
				break;
			case 4:
				try {
					List< ContractBean> contract1 = services.getAllContracts();
					if (contract1 != null) {
						System.out.println("Contract Details : ");
						for (ContractBean contractBean : contract1) {
							System.out.println("Contract No : " + contractBean.getContractNo());
							System.out.println("Customer Id : " + contractBean.getCustomerId());
							System.out.println("Product Id : " + contractBean.getProductId());
							System.out.println("Haulier Id : " + contractBean.getHaulierId());
							System.out.println("Delivery Date : " + contractBean.getDeliveryDate());
							System.out.println("Delivary day : " + contractBean.getDeliveryDay());
							System.out.println("Quantity : " + contractBean.getQuantity());
							System.out.println("***********************************************");
						}
					} else {
						System.err.println("No Contracts found");
					}
				} catch (Exception e) {
					System.err.println("Something Went Wrong");
				}
				break;
			case 5:
				System.out.println("Enter ContractNo to modify contract");
				try {
					int contractNo1 = scanner.nextInt();
					List< ContractBean> contract2 = services.getAllContracts();
					boolean isupdate = false;
					for (ContractBean contractBean : contract2) {
						if (contractBean.getContractNo() == contractNo1) {
							isupdate = true;
						}
					}
					if (isupdate) {
						System.out.println("Enter Delivery Date(yyy-mm-dd)");
						String newDeliveryDate = scanner.next();
						boolean isValidNewDate = validations.dateValidation(newDeliveryDate);
						while (!isValidNewDate) {
							System.err.println("Please enter delivery date again(yyy-mm-dd)");
							newDeliveryDate = scanner.next();
							if (validations.dateValidation(newDeliveryDate)) {
								break;
							}
						}
						contract.setDeliveryDate(newDeliveryDate);
						System.out.println("enter quantity");
						String newQuantity = scanner.next();
						boolean isValidNewProductId = validations.idValidation(newQuantity);
						while (!isValidNewProductId) {
							System.err.println("Please quantity again");
							newQuantity = scanner.next();
							if (validations.idValidation(newQuantity)) {
								break;
							}
						}
						contract.setQuantity(Integer.parseInt(newQuantity));
						boolean check1 = services.updateContract(contractNo1, contract);
						if (check1) {
							System.out.println(contractNo1 + " updated succesfully");
						} else {
							System.err.println(contractNo1 + " data not present");
						}
					} else {
						System.err.println(contractNo1 + " is not present");
					}
				} catch (Exception e) {
					System.err.println("No Contracts present to update");
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
