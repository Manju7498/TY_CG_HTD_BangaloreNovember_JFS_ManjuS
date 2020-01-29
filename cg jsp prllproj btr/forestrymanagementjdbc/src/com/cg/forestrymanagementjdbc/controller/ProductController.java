package com.cg.forestrymanagementjdbc.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.cg.forestrymanagementjdbc.bean.ProductBean;
import com.cg.forestrymanagementjdbc.factory.ProductFactory;
import com.cg.forestrymanagementjdbc.main.MainForestry;
import com.cg.forestrymanagementjdbc.service.ProductService;
import com.cg.forestrymanagementjdbc.validations.Validations;

public class ProductController {
	public void product() {
		ProductService services = ProductFactory.instanceofProductServices();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		ProductBean bean = new ProductBean();
		Validations validations = new Validations();
		while (true) {
			System.out.println("Enter 1 to insert product data");
			System.out.println("Enter 2 to delete product data");
			System.out.println("Enter 3 to get product data");
			System.out.println("Enter 4 to get all product data");
			System.out.println("Enter 5 to update product  data");
			System.out.println("Enter 6 to return to  home");
			String choice = scanner.next();
			Pattern pattern = Pattern.compile("^[1-6]{1}$");
			ProductBean productBean = new ProductBean();
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
					System.out.println("Enter product Id");
					String productId = scanner.next();
					boolean isValidId = validations.idValidation(productId);
					while (!isValidId) {
						System.err.println("Please enter product Id again");
						productId = scanner.next();
						if (validations.idValidation(productId)) {
							break;
						}
					}
					productBean.setProductId(Integer.parseInt(productId));
					System.out.println("Enter product name");
					String productName = scanner.next();
					boolean isValidName = validations.nameValidation(productName);
					while (!isValidName) {
						System.err.println("Please enter name again");
						productName = scanner.next();
						if (validations.nameValidation(productName)) {
							break;
						}
					}
					productBean.setProductName(productName);
					System.out.println("Your product orderdate");
					LocalDate today = LocalDate.now();
					String productOrderDate = today.toString();
					System.out.println(productOrderDate);
					productBean.setProductOrderDate(productOrderDate);
					System.out.println("Enter product deliverydate(yyyy-mm-dd)");
					String deliveryDate = scanner.next();
					boolean isValidDate1 = validations.dateValidation(deliveryDate);
					while (!isValidDate1) {
						System.err.println("Please enter date again(yyyy-mm-dd)");
						deliveryDate = scanner.next();
						if (validations.dateValidation(deliveryDate)) {
							break;
						}
					}
					productBean.setProductDeliveryDate(deliveryDate);
					boolean check = services.insertProduct(productBean);
					if (check) {
						System.out.println("product "+productBean.getProductId()+"  added");
					} else {
						System.err.println(productBean.getProductId()+" Id is repeated");
					}
				} catch (Exception e) {
					System.err.println("Product cannot be added");
				}
				break;
			case 2:
				System.out.println("Enter Id to delete product");
				try {
					int choicetodelete = scanner.nextInt();
					if (services.deleteProduct(choicetodelete)) {
						System.out.println("product "+productBean.getProductId()+" deleted");
					} else {
						System.err.println("product Id "+productBean.getProductId()+" found to delete");
					}
				} catch (Exception e) {
					System.err.println("product Id is invalid");
				}
				break;
			case 3:
				System.out.println("Enter Id to search product");
				try {
					int productId = scanner.nextInt();
					if (bean != null) {
						ProductBean productBean1 = services.productLogin(productId);
						System.out.println("Product name : " + productBean1.getProductName());
						System.out.println("product order date : " + productBean1.getProductOrderDate());
						System.out.println("product delivery date : " + productBean1.getProductDeliveryDate());
						System.out.println();
					}
				} catch (Exception e) {
					System.out.println("Such ProductId is  not found");
				}
				break;
			case 4:
				try {
					List<ProductBean> product = services.getAllProducts();
					System.out.println("product Details : ");
					if (product != null) {
						for (ProductBean productBean2 : product) {
							System.out.println("Product Id : " + productBean2.getProductId());
							System.out.println("Product name : " + productBean2.getProductName());
							System.out.println("product order date : " + productBean2.getProductOrderDate());
							System.out.println("product delivery date : " + productBean2.getProductDeliveryDate());
							System.out.println();
						}
					}else {
						System.err.println("No products found");
					}
				} catch (Exception e) {
					System.err.println("No products found");
				}
				break;
			case 5:
				System.out.println("Enter Id to modify product data ");
				try {
					bean = new ProductBean();
					int productId1 = scanner.nextInt();
					List<ProductBean> product2 = services.getAllProducts();
					boolean isUpdate = false;
					for (ProductBean productBean2 : product2) {
						if (productBean2.getProductId() == productId1) {
							isUpdate = true;
						}
					}
					if(isUpdate) {
					System.out.println("Enter product name");
					String newProductName = scanner.next();
					boolean isValidNewName = validations.nameValidation(newProductName);
					while (!isValidNewName) {
						System.out.println("Please enter product name again");
						newProductName = scanner.next();
						if (validations.nameValidation(newProductName)) {
							break;
						}
					}
					bean.setProductName(newProductName);
					boolean check1 = services.updateProduct(productId1, bean);
					if (check1) {
						System.out.println("product "+productBean.getProductId()+" updated succesfully");
					} else {
						System.out.println("product "+productBean.getProductId()+" found to update");
					}
					}else {
						System.err.println("Product "+productBean.getProductId()+" not found");
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
