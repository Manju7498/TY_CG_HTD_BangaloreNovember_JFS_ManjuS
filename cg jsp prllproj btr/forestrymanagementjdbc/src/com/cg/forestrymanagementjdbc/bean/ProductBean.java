package com.cg.forestrymanagementjdbc.bean;

import java.io.Serializable;

@SuppressWarnings("serial")
public class ProductBean implements Serializable {
	private int productId;
	private String productName;
	private String productOrderDate;
	private String productDeliveryDate;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductOrderDate() {
		return productOrderDate;
	}

	public void setProductOrderDate(String productOrderDate) {
		this.productOrderDate = productOrderDate;
	}

	public String getProductDeliveryDate() {
		return productDeliveryDate;
	}

	public void setProductDeliveryDate(String productDeliveryDate) {
		this.productDeliveryDate = productDeliveryDate;
	}

	
}
