package com.cg.forestmanagementspringrest.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Product")
public class ProductBean {
	@Id
	@Column
	private String productId;
	@Column
	private String productName;
	@Column
	private String productOrderDate;
	@Column
	private String productDeliveryDate;
	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
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
