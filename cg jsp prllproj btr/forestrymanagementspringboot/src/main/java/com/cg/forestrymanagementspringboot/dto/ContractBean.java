package com.cg.forestrymanagementspringboot.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Contract")
public class ContractBean {
	@Id
	@Column
	private String contractNo;
	@Column
	private String customerId;
	@Column
	private String productId;
	@Column
	private String haulierId;
	@Column
	private String deliveryDate;
	@Column
	private String quantity;
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getHaulierId() {
		return haulierId;
	}
	public void setHaulierId(String haulierId) {
		this.haulierId = haulierId;
	}
	public String getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	

	
}
