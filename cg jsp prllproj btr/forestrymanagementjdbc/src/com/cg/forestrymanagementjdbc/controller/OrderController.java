package com.cg.forestrymanagementjdbc.controller;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.forestrymanagementjdbc.bean.OrderBean;
import com.cg.forestrymanagementjdbc.factory.OrderFactory;
import com.cg.forestrymanagementjdbc.main.MainForestry;
import com.cg.forestrymanagementjdbc.service.OrderService;
import com.cg.forestrymanagementjdbc.validations.Validations;

public class OrderController {
	public void order() {
		OrderService services = OrderFactory.instanceofOrderServices();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		OrderBean bean = new OrderBean();
		Validations validations = new Validations();
		while (true) {
			System.out.println("Enter 1 to insert order data");
			System.out.println("Enter 2 to delete order data");
			System.out.println("Enter 3 to get order data");
			System.out.println("Enter 4 to get all order data");
			System.out.println("Enter 5 to update order  data");
			System.out.println("Enter 6 to return to  home");
			String choice = scanner.next();
			Pattern pattern = Pattern.compile("^[1-6]{1}$");
			OrderBean orderBean = new OrderBean();
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
					System.out.println("Enter Order no");
					String orderNo = scanner.next();
					boolean isValidId = validations.idValidation(orderNo);
					while (!isValidId) {
						System.err.println("Please enter order no again");
						orderNo = scanner.next();
						if (validations.idValidation(orderNo)) {
							break;
						}
					}
					orderBean.setOrderNo(Integer.parseInt(orderNo));
					System.out.println("Enter customer Id");
					String customerId = scanner.next();
					boolean isValidName = validations.idValidation(customerId);
					while (!isValidName) {
						System.err.println("Please enter customer Id again");
						customerId = scanner.next();
						if (validations.idValidation(customerId)) {
							break;
						}
					}
					orderBean.setCustomerId(Integer.parseInt(customerId));
					System.out.println("Enter product Id");
					String productId = scanner.next();
					boolean isValidName1 = validations.idValidation(productId);
					while (!isValidName1) {
						System.err.println("Please enter product Id again");
						productId = scanner.next();
						if (validations.idValidation(productId)) {
							break;
						}
					}
					orderBean.setProductId(Integer.parseInt(productId));
					System.out.println("Enter haulier Id");
					String haulierId = scanner.next();
					boolean isValidName2 = validations.idValidation(haulierId);
					while (!isValidName2) {
						System.err.println("Please enter  haulier Id again");
						haulierId = scanner.next();
						if (validations.idValidation(haulierId)) {
							break;
						}
					}
					orderBean.setHaulierId(Integer.parseInt(haulierId));
					System.out.println("Enter delivery date(yyyy-mm-dd)");
					String deliveryDate = scanner.next();
					boolean isValidDate = validations.dateValidation(deliveryDate);
					while (!isValidDate) {
						System.err.println("Please enter date again(yyyy-mm-dd)");
						deliveryDate = scanner.next();
						if (validations.dateValidation(deliveryDate)) {
							break;
						}
					}
					orderBean.setDeliveryDate(deliveryDate);
					System.out.println("Enter quantity");
					String quantity = scanner.next();
					boolean isValid = validations.idValidation(quantity);
					while (!isValid) {
						System.err.println("Please enter quantity again");
						quantity = scanner.next();
						if (validations.idValidation(quantity)) {
							break;
						}
					}
					orderBean.setQuantity(Integer.parseInt(quantity));
					boolean check = services.insertOrder(orderBean);
					if (check) {
						System.out.println("order "+orderBean.getOrderNo()+" added");
					} else {
						System.err.println(orderBean.getOrderNo()+" is repeated");
					}
				} catch (Exception e) {
					System.err.println("Order cannot be added");
				}
				break;
			case 2:
				System.out.println("Enter Id to delete order");
				try {
					int choicetodelete = scanner.nextInt();
					if (services.deleteOrder(choicetodelete)) {
						System.out.println("order "+orderBean.getOrderNo()+" deleted");
					} else {
						System.err.println("order "+orderBean.getOrderNo()+" not found to delete");
					}
				} catch (Exception e) {
					System.err.println("Order no is invalid");
				}
				break;
			case 3:
				System.out.println("Enter No to search order");
				try {
					int orderId = scanner.nextInt();
					if (bean != null) {
						OrderBean orderBean1 = services.orderLogin(orderId);
						System.out.println("Customer Id : " + orderBean1.getCustomerId());
						System.out.println("Product Id : " + orderBean1.getProductId());
						System.out.println("Haulier Id : " + orderBean1.getHaulierId());
						System.out.println("Delivery date : " + orderBean1.getDeliveryDate());
						System.out.println("Quantity : " + orderBean1.getQuantity());
						System.out.println();
					}
				} catch (Exception e) {
					System.err.println("No such order No   not found");
				}
				break;
			case 4:
				try {
					List<OrderBean> order = services.getAllOrders();
					System.out.println("Order Details : ");
					if (order != null) {
						for (OrderBean orderBean2 : order) {
							System.out.println("Order No : " + orderBean2.getOrderNo());
							System.out.println("Customer Id : " + orderBean2.getCustomerId());
							System.out.println("Product Id : " + orderBean2.getProductId());
							System.out.println("Haulier Id : " + orderBean2.getHaulierId());
							System.out.println("Delivery date : " + orderBean2.getDeliveryDate());
							System.out.println("Quantity : " + orderBean2.getQuantity());
							System.out.println();
						}
					}else {
						System.err.println("No orders found");
					}
				} catch (Exception e) {
					System.err.println("No orders found");
				}
				break;
			case 5:
				System.out.println("Enter order No to modify order data ");
				try {
					bean = new OrderBean();
					int orderNo1 = scanner.nextInt();
					List<OrderBean> order2 = services.getAllOrders();
					boolean isUpdate = false;
					for (OrderBean orderBean2 : order2) {
						if (orderBean2.getOrderNo() == orderNo1) {
							isUpdate = true;
						}
					}
					if(isUpdate) {
					System.out.println("Enter new customer Id");
					String newCustomerId = scanner.next();
					boolean isValidNewId = validations.idValidation(newCustomerId);
					while (!isValidNewId) {
						System.err.println("Please enter customer Id again");
						newCustomerId = scanner.next();
						if (validations.idValidation(newCustomerId)) {
							break;
						}
					}
					bean.setCustomerId(Integer.parseInt(newCustomerId));
					System.out.println("Enter new product Id");
					String newProductId = scanner.next();
					boolean isValidNewProductId = validations.idValidation(newProductId);
					while (!isValidNewProductId) {
						System.err.println("Please enter product Id again");
						newProductId = scanner.next();
						if (validations.idValidation(newProductId)) {
							break;
						}
					}
					bean.setProductId(Integer.parseInt(newProductId));
					boolean check1 = services.updateOrder(orderNo1, bean);
					if (check1) {
						System.out.println("Order "+orderNo1+" updated succesfully");
					} else {
						System.out.println("Order "+orderNo1+" not found to update");
					}}else {
						System.err.println("Order "+orderNo1+" not found");
					}
				} catch (Exception e) {
					System.err.println("order No not found");
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
