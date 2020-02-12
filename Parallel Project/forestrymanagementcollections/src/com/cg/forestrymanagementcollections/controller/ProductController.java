package com.cg.forestrymanagementcollections.controller;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

import com.cg.forestrymanagementcollections.bean.ProductBean;
import com.cg.forestrymanagementcollections.factory.ProductFactory;
import com.cg.forestrymanagementcollections.main.MainForestry;
import com.cg.forestrymanagementcollections.service.ProductService;
import com.cg.forestrymanagementcollections.validations.Validations;

import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductController {
	public void product() {
		ProductService services = ProductFactory.instanceofProductServices();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Validations validations = new Validations();
		while (true) {
			System.out.println("Enter 1 to insert product");
			System.out.println("Enter 2 to delete product");
			System.out.println("Enter 3 to get product data");
			System.out.println("Enter 4 to get all product data");
			System.out.println("Enter 5 to update product data");
			System.out.println("Enter 6  to return to  home");
			ProductBean product = new ProductBean();
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
					System.out.println("Enter product id");
					String productId = scanner.next();
					boolean isValidId = validations.idValidation(productId);
					while (!isValidId) {
						System.err.println("Please enter product Id again");
						productId = scanner.next();
						if (validations.idValidation(productId)) {
							break;
						}
					}
					product.setProductId(Integer.parseInt(productId));
					System.out.println("Enter product name");
					String productName = scanner.next();
					boolean isValidName = validations.nameValidation(productName);
					while (!isValidName) {
						System.err.println("Please enter product name again");
						productName = scanner.next();
						if (validations.nameValidation(productName)) {
							break;
						}
					}
					product.setProductName(productName);
					System.out.println("Your product order date");
					LocalDate today = LocalDate.now();
					String productOrderDate = today.toString();
					System.out.println(productOrderDate);
					product.setProductOrderDate(productOrderDate);
					System.out.println("Enter product delivery date(yyyy-mm-dd)");
					String productDeliveryDate = scanner.next();
					boolean isValidDeliveryDate = validations.dateValidation(productDeliveryDate);
					while (!isValidDeliveryDate) {
						System.err.println("Please enter valid product delivery date again(yyyy-mm-dd)");
						productDeliveryDate = scanner.next();
						if (validations.dateValidation(productDeliveryDate)) {
							break;
						}
					}
					product.setProductDeliveryDate(productDeliveryDate);
					boolean check = services.addProduct(Integer.parseInt(productId), product);
					if (check) {
						System.out.println("Product " + productId + " is added successfully");
					} else {
						System.err.println("Product " + productId + " is repeated");
					}
					break;
				} catch (Exception e) {
					System.err.println("Something went wrong in adding...Please try again");
				}
				break;
			case 2:
				System.out.println("Enter id to delete product");
				try {
					int productId = scanner.nextInt();
					if (services.deleteProduct(productId)) {
						System.out.println("Product " + productId + " is deleted");
					} else {
						System.err.println("Product " + productId + "  not found to delete");
					}
				} catch (Exception e) {
					System.err.println("ProductId is invalid");
				}
				break;
			case 3:
				System.out.println("Enter id to search product");
				try {
					int productId = scanner.nextInt();
					if (product != null) {
						ProductBean cbean = services.getProduct(productId);
						System.out.println("product name : " + cbean.getProductName());
						System.out.println("product Order Date : " + cbean.getProductOrderDate());
						System.out.println("product Delivery Date : " + cbean.getProductDeliveryDate());
					}
				} catch (Exception e) {
					System.err.println("This Product Id is not found");
				}
				break;
			case 4:
				try {
					HashMap<Integer, ProductBean> product1 = services.getAllProducts();
					if (product1 != null) {
						System.out.println("all product details");
						for (Entry<Integer, ProductBean> productBean : product1.entrySet()) {
							System.out.println("Product id : " + productBean.getKey());
							System.out.println("product name : " + productBean.getValue().getProductName());
							System.out.println("product Order Date : " + productBean.getValue().getProductOrderDate());
							System.out.println(
									"product Delivery Date : " + productBean.getValue().getProductDeliveryDate());
							System.out.println("**************************************");
						}
					} else {
						System.err.println("No Products found");
					}
				} catch (Exception e) {
					System.err.println("Something Went Wrong");
				}
				break;
			case 5:
				System.out.println("Enter Id to modify product");
				try {
					int productId = scanner.nextInt();
					HashMap<Integer, ProductBean> product2 = services.getAllProducts();
					boolean isUpdate = false;
					for (Entry<Integer, ProductBean> product3 : product2.entrySet()) {
						if (product3.getKey() == productId) {
							isUpdate = true;
						}
					}
					if (isUpdate) {
						System.out.println("Enter new product name");
						String newProductName = scanner.next();
						boolean isValidNewName = validations.nameValidation(newProductName);
						while (!isValidNewName) {

							System.err.println("Please enter product name again");
							newProductName = scanner.next();
							if (validations.nameValidation(newProductName)) {
								break;
							}
						}
						product.setProductName(newProductName);
						System.out.println("Your product order date");
						LocalDate today = LocalDate.now();
						String productOrderDate = today.toString();
						System.out.println(productOrderDate);
						product.setProductOrderDate(productOrderDate);
						System.out.println("Enter new product delivery date(yyyy-mm-dd)");
						String newProductDeliveryDate = scanner.next();
						boolean isValidNewDeliveryDate = validations.dateValidation(newProductDeliveryDate);
						while (!isValidNewDeliveryDate) {
							System.err.println("Please enter product delivery date again(yyyy-mm-dd)");
							newProductDeliveryDate = scanner.next();
							if (validations.dateValidation(newProductDeliveryDate)) {
								break;
							}
						}
						product.setProductDeliveryDate(newProductDeliveryDate);
						boolean check1 = services.updateProduct(productId, product);
						if (check1) {
							System.out.println(productId + " updated succesfully");
						} else {
							System.err.println(productId + " data not present");
						}
					} else {
						System.err.println(productId + " is not present");
					}
				} catch (Exception e) {
					System.err.println("No Products present to update");
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
