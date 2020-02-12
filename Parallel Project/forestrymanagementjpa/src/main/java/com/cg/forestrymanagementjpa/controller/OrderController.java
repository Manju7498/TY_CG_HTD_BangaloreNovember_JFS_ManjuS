package com.cg.forestrymanagementjpa.controller;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.forestrymanagementjpa.bean.CustomerBean;
import com.cg.forestrymanagementjpa.bean.HaulierBean;
import com.cg.forestrymanagementjpa.bean.OrderBean;
import com.cg.forestrymanagementjpa.bean.ProductBean;
import com.cg.forestrymanagementjpa.factory.CustomerFactory;
import com.cg.forestrymanagementjpa.factory.HaulierFactory;
import com.cg.forestrymanagementjpa.factory.OrderFactory;
import com.cg.forestrymanagementjpa.factory.ProductFactory;
import com.cg.forestrymanagementjpa.main.MainForestry;
import com.cg.forestrymanagementjpa.service.CustomerService;
import com.cg.forestrymanagementjpa.service.HaulierService;
import com.cg.forestrymanagementjpa.service.OrderService;
import com.cg.forestrymanagementjpa.service.ProductService;
import com.cg.forestrymanagementjpa.validations.Validations;

public class OrderController {
	public void order() {
		OrderService services = OrderFactory.instanceofOrderServices();
		CustomerService customerService= CustomerFactory.instanceofCustomerServices();
		ProductService productService=ProductFactory.instanceofProductServices();
		HaulierService haulierService=HaulierFactory.instanceofHaulierServices();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Validations validations = new Validations();
		while (true) {
			System.out.println("Enter 1 to insert order data");
			System.out.println("Enter 2 to delete order data");
			System.out.println("Enter 3 to get order data");
			System.out.println("Enter 4 to get all order details");
			System.out.println("Enter 5 to update order data");
			System.out.println("Enter 6 to return to home");
			OrderBean order = new OrderBean();
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
					System.out.println("Enter orderno");
					String orderNo = scanner.next();
					boolean isValidNo = validations.idValidation(orderNo);
					while (!isValidNo) {
						System.err.println("Please enter order no again");
						orderNo = scanner.next();
						if (validations.idValidation(orderNo)) {
							break;
						}
					}
					order.setOrderNo(Integer.parseInt(orderNo));
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
						while(isValidId!= validations.idValidation(customerId)) {
							System.err.println("Please enter customer Id again");
							customerId = scanner.next();
							if (validations.idValidation(customerId)) {
								break;
							}
						}
						if (customerService.customerLogin(Integer.parseInt(customerId))!=null) 
							break;
					}
					order.setCustomerId(Integer.parseInt(customerId));
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
					order.setProductId(Integer.parseInt(productId));
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
						while(isValidHaulierId != validations.idValidation(haulierId)) {
							System.err.println("Please enter haulier Id again");
							haulierId = scanner.next();
							if (validations.idValidation(haulierId)) {
								break;
							}
						}
						if (haulierService.haulierLogin(Integer.parseInt(haulierId))!=null) 
							break;
					}
					order.setHaulierId(Integer.parseInt(haulierId));
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
					order.setDeliveryDate(deliveryDate);
					System.out.println("Enter quantity");
					String quantity = scanner.next();
					boolean isValidQuantity = validations.idValidation(quantity);
					while (!isValidQuantity) {
						System.err.println("Please enter quantity again");
						quantity = scanner.next();
						if (validations.idValidation(quantity)) {
							break;
						}
					}
					order.setQuantity(Integer.parseInt(quantity));
					boolean check = services.insertOrder(order);
					if (check) {
						System.out.println("Order " + orderNo + " is added successfully");
					} else {
						System.err.println("Order " + orderNo + " is repeated");
					}
					break;
				} catch (Exception e) {
					System.err.println("Something went wrong in adding...Please try again");
				}
				break;
			case 2:
				System.out.println("Enter orderNo to delete order");
				try {
					int orderNo = scanner.nextInt();
					if (services.deleteOrder(orderNo)) {
						System.out.println("Order " + orderNo + " is deleted");
					} else {
						System.err.println("Order " + orderNo + " not found to delete");
					}
				} catch (Exception e) {
					System.err.println("OrderId is invalid");
				}
				break;
			case 3:
				System.out.println("Enter orderNo to search customer");
				try {
					int orderNo = scanner.nextInt();
					if (order != null) {
						OrderBean orderBean1 = services.orderLogin(orderNo);
						System.out.println("Order No : " + orderBean1.getOrderNo());
						System.out.println("Customer Id : " + orderBean1.getCustomerId());
						System.out.println("Product id : " + orderBean1.getProductId());
						System.out.println("Haulier Id : " + orderBean1.getHaulierId());
						System.out.println("Delivery date : " + orderBean1.getDeliveryDate());
						System.out.println("Quantity : " + orderBean1.getQuantity());
						System.out.println();
					}
				} catch (Exception e) {
					System.err.println("This Order No is not found");
				}
				break;
			case 4:
				try {
					List<OrderBean> order1 = services.getAllOrders();
					if (order1 != null) {
						System.out.println("Order Details : ");
						for (OrderBean orderbean : order1) {
							System.out.println("Contract No : " + orderbean.getOrderNo());
							System.out.println("Customer id : " + orderbean.getCustomerId());
							System.out.println("Product Id : " + orderbean.getProductId());
							System.out.println("Haulier Id : " + orderbean.getHaulierId());
							System.out.println("Delivery Date : " + orderbean.getDeliveryDate());
							System.out.println("Quantity : " + orderbean.getQuantity());
							System.out.println("*****************************************");
							System.out.println();
						}
					} else {
						System.err.println("No Orders found");
					}
				} catch (Exception e) {
					System.err.println("Something Went Wrong");
				}
				break;
			case 5:
				System.out.println("Enter id to modify order");
				try {
					int orderNo = scanner.nextInt();
					List<OrderBean> order2 = services.getAllOrders();
					boolean isupdate = false;
					for (OrderBean order3 : order2) {
						if (order3.getOrderNo() == orderNo) {
							isupdate = true;
						}
					}
					if (isupdate) {
						
						System.out.println("enter delivery date(yyyy-mm-dd)");
						String newDeliveryDate = scanner.next();
						boolean isValidNewDate = validations.dateValidation(newDeliveryDate);
						while (!isValidNewDate) {
							System.err.println("Please enter delivery date again(yyyy-mm-dd)");
							newDeliveryDate = scanner.next();
							if (validations.dateValidation(newDeliveryDate)) {
								break;
							}
						}
						order.setDeliveryDate(newDeliveryDate);
						System.out.println("enter quantity");
						String newQuantity = scanner.next();
						boolean isValidQuantity1 = validations.idValidation(newQuantity);
						while (!isValidQuantity1) {
							System.err.println("Please enter quantity again");
							newQuantity = scanner.next();
							if (validations.idValidation(newQuantity)) {
								break;
							}
						}
						order.setQuantity(Integer.parseInt(newQuantity));
						boolean check1 = services.updateOrder(orderNo, order);
						if (check1) {
							System.out.println(orderNo + " updated succesfully");
						} else {
							System.err.println(orderNo + " data not present");
						}
					} else {
						System.err.println(orderNo + " is not present");
					}
				} catch (Exception e) {
					System.err.println("No Orders present to update");
				}
				break;
			case 6:
				MainForestry.home();
				return;
			default:
				break;
			}
		}
	}
}
