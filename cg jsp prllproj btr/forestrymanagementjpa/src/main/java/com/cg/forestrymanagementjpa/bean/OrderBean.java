package com.cg.forestrymanagementjpa.bean;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Orders")
public class OrderBean {
	@Id
	@Column
	private int orderNo;
	@Column
	private int customerId;
	@Column
	private int haulierId;
	@Column
	private int productId;

	@Column
	private String deliveryDate;
	@Column
	private int quantity;
	public int getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getDeliveryDate() {
		return deliveryDate;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public int getHaulierId() {
		return haulierId;
	}
	public void setHaulierId(int haulierId) {
		this.haulierId = haulierId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public void setDeliveryDate(String deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
